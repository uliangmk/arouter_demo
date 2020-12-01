package com.blued.c_module_main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blued.common.base.BaseActivity;
import com.blued.common.constants.ARouterConfig;

@Route(path = ARouterConfig.VIEW_MAIN)
public class MainActivity extends BaseActivity {

    private View module1, module2, module3;
    private NavigationCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
        initView();
        initCallBack();
        initListener();
    }

    private void initView() {
        module1 = findViewById(R.id.bt_module1);
        module2 = findViewById(R.id.bt_module2);
        module3 = findViewById(R.id.bt_module3);
    }

    private void initListener() {
        module1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterConfig.VIEW_ONE).navigation(MainActivity.this, callback);
            }
        });
        module2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterConfig.VIEW_TWO).navigation(MainActivity.this, callback);
            }
        });

        module3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConfig.VIEW_THREE).navigation(MainActivity.this, callback);
            }
        });
    }

    private void initCallBack() {
        callback = new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {

            }

            @Override
            public void onLost(Postcard postcard) {
                Toast.makeText(MainActivity.this, "组件没有找到", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onArrival(Postcard postcard) {
                Toast.makeText(MainActivity.this, "跳转成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterrupt(Postcard postcard) {

            }
        };
    }


}