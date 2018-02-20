package future.com.selfdefineviewfirst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import future.com.selfdefineviewfirst.view.CustomView;

public class MainActivity extends AppCompatActivity implements CustomView.CustomListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((CustomView) this.findViewById(R.id.custom1)).setCustomListener(this);
    }


    @Override
    public void onCuscomClick(View v, int custom_id) {
        switch (custom_id) {
            case 1:
                Toast.makeText(this, "你点我干嘛？！", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    /**
     * 跳转下一页
     *
     * @param view
     */
    public void changeNextPage(View view) {
        startActivity(new Intent(this, CustomImageViewActivity.class));
    }

    /**
     * 跳转进度条展示页
     *
     * @param view
     */
    public void changeToProgress(View view) {
        startActivity(new Intent(this, CircleProgressActivity.class));
    }
}
