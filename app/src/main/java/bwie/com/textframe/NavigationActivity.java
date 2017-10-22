package bwie.com.textframe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/8
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class NavigationActivity extends AppCompatActivity {
    @BindView(R.id.time)
    TextView mTime;
    @BindView(R.id.jump)
    Button mJump;
    //计时器
    private int time = 5;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                mTime.setText(time + "秒");
                if (time > 0) {
                    time--;
                    mHandler.sendEmptyMessageDelayed(0, 1000);
                } else if (time == 0) {
                    startActivity(new Intent(NavigationActivity.this, MainActivity.class));
                    finish();
                }
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);

        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    @OnClick({R.id.time, R.id.jump})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.time:
                break;
            case R.id.jump:
                mHandler.removeCallbacksAndMessages(null);
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }
}
