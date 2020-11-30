package com.blued.c_module_main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blued.common.base.BaseActivity;
import com.blued.common.constants.ARouterConfig;
@Route(path = ARouterConfig.VIEW_MAIN)
public class MainActivity extends BaseActivity {

    private View module1, module2, module3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("ulog","onCreate -- MainActivity"+" ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
        initView();
        initListener();
        ARouter.getInstance().inject(this);
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
                ARouter.getInstance().build(ARouterConfig.VIEW_ONE).navigation();
                Toast.makeText(MainActivity.this, "one", Toast.LENGTH_SHORT).show();
            }
        });
        module2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterConfig.VIEW_TWO).navigation();
                Toast.makeText(MainActivity.this, "two", Toast.LENGTH_SHORT).show();
            }
        });

        module3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConfig.VIEW_THREE).navigation();
                Toast.makeText(MainActivity.this, "three", Toast.LENGTH_SHORT).show();
            }
        });

    }

}