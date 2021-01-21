package com.blued.b_module_three;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blued.c_module_main.MainActivity;
import com.blued.common.base.BaseActivity;
import com.blued.common.constants.ARouterConfig;

/**
 * @Author： ZhangYuLiang
 * @description：
 */
@Route(path = ARouterConfig.VIEW_THREE)
public class ThreeActivity extends BaseActivity {
    private View module1, module2, tvEvent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_main);
        initView();
        initCallBack();
        initListener();
    }

    private void initView() {
        module1 = findViewById(R.id.bt_module1);
        module2 = findViewById(R.id.bt_module2);
        tvEvent = findViewById(R.id.bt_event_test);
    }

    private void initListener() {
        module1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterConfig.VIEW_ONE).navigation(ThreeActivity.this, callback);
            }
        });

        module2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConfig.VIEW_TWO).navigation(ThreeActivity.this, callback);
            }
        });
        tvEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeActivity.this, EventTestActivity.class);
                startActivity(intent);
            }
        });

    }

    private NavigationCallback callback;

    private void initCallBack() {
        callback = new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {

            }

            @Override
            public void onLost(Postcard postcard) {
                Toast.makeText(ThreeActivity.this, "组件没有找到", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onArrival(Postcard postcard) {
                Toast.makeText(ThreeActivity.this, "跳转成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterrupt(Postcard postcard) {

            }
        };
    }
}
