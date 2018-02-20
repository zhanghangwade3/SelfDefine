package future.com.selfdefineviewfirst;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import future.com.selfdefineviewfirst.view.CustomImageView;

/**
 * 类说明：CustomImageView 展示页面
 * 增加：控件点击事件
 * <p/>
 * 作者：hang
 * 时间：2016/7/15
 */
public class CustomImageViewActivity extends Activity implements CustomImageView.CustomImageViewClickListener {
    /**
     * 第一个控件
     */
    private CustomImageView pengyuyan1;
    /**
     * 第二个控件
     */
    private CustomImageView pengyuyan2;
    /**
     * 第三个控件
     */
    private CustomImageView pengyuyan3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_image_view);
        pengyuyan1 = (CustomImageView) findViewById(R.id.pengyuyan1);
        pengyuyan2 = (CustomImageView) findViewById(R.id.pengyuyan2);
        pengyuyan3 = (CustomImageView) findViewById(R.id.pengyuyan3);

        pengyuyan1.setListener(this);
        pengyuyan2.setListener(this);
        pengyuyan3.setListener(this);
    }

    @Override
    public void onCustomImageViewClickListener(View v) {
        switch (v.getId()) {
            case R.id.pengyuyan1:
                Toast.makeText(this, "帅哥彭于晏1", Toast.LENGTH_LONG).show();
                break;
            case R.id.pengyuyan2:
                Toast.makeText(this, "德艺双馨彭于晏2", Toast.LENGTH_LONG).show();

                break;
            case R.id.pengyuyan3:
                Toast.makeText(this, "超越自己彭于晏3", Toast.LENGTH_LONG).show();
                break;
        }

    }
}
