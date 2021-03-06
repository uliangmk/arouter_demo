package com.blued.b_module_two;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blued.common.base.BaseActivity;
import com.blued.common.constants.ARouterConfig;

/**
 * @Author： ZhangYuLiang
 * @description：
 */
@Route(path = ARouterConfig.VIEW_TWO)
public class TwoActivity extends BaseActivity {
    private View module1, module3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        initView();
        initCallBack();
        initListener();
    }

    private void initView() {
        module1 = findViewById(com.blued.c_module_main.R.id.bt_module1);
        module3 = findViewById(com.blued.c_module_main.R.id.bt_module3);
    }

    private void initListener() {
        module1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterConfig.VIEW_ONE).navigation(TwoActivity.this, callback);
            }
        });

        module3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConfig.VIEW_THREE).navigation(TwoActivity.this, callback);
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
                Toast.makeText(TwoActivity.this, "组件没有找到", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onArrival(Postcard postcard) {
                Toast.makeText(TwoActivity.this, "跳转成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterrupt(Postcard postcard) {

            }
        };
    }
}
