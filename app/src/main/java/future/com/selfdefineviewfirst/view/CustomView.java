package future.com.selfdefineviewfirst.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import future.com.selfdefineviewfirst.R;

/**
 * 类说明：带阴影的按钮，按钮正下方有文字说明
 * 作者：vision
 * 时间：2016/7/15
 */
public class CustomView extends FrameLayout implements View.OnClickListener {
    private CustomListener customListener = null;
    private Drawable mSrc = null, mBackground = null;
    private String mText = "";
    private int mTextColor = 0;
    private float mTextSize = 20;
    private int mCustomId = 0;
    private ImageView mBackgroundView = null;
    private ImageButton mButtonView = null;
    private TextView mTextView = null;
    private LayoutParams mParams = null;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.custom_view);
        mSrc = a.getDrawable(R.styleable.custom_view_src);
        mBackground = a.getDrawable(R.styleable.custom_view_backg);
        mText = a.getString(R.styleable.custom_view_text);
        mTextColor = a.getColor(R.styleable.custom_view_textColor, Color.WHITE);
        mTextSize = a.getDimension(R.styleable.custom_view_textSize, 20);
        mCustomId = a.getInt(R.styleable.custom_view_custom_id, 0);
        mTextView = new TextView(context);
        mTextView.setTextSize(mTextSize);
        mTextView.setTextColor(mTextColor);
        mTextView.setText(mText);
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        mButtonView = new ImageButton(context);
        mButtonView.setImageDrawable(mSrc);
        mButtonView.setBackgroundDrawable(null);
        mButtonView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        mButtonView.setOnClickListener(this);
        mBackgroundView = new ImageView(context);
        mBackgroundView.setImageDrawable(mBackground);
        mBackgroundView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(mBackgroundView);
        addView(mButtonView);
        addView(mTextView);
        this.setOnClickListener(this);
        a.recycle();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mParams = (LayoutParams) mButtonView.getLayoutParams();
        if (mParams != null) {
            mParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.TOP;
            mButtonView.setLayoutParams(mParams);
        }
        mParams = (LayoutParams) mBackgroundView.getLayoutParams();
        if (mParams != null) {
            mParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.TOP;
            mBackgroundView.setLayoutParams(mParams);
        }
        mParams = (LayoutParams) mTextView.getLayoutParams();
        if (mParams != null) {
            mParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
            mTextView.setLayoutParams(mParams);
        }
    }

    public void setCustomListener(CustomListener l) {
        customListener = l;
    }

    @Override
    public void onClick(View v) {
        if (customListener != null) {
            customListener.onCuscomClick(v, mCustomId);
        }
    }

    public interface CustomListener {
        void onCuscomClick(View v, int custom_id);
    }
}
