package com.blued.b_module_one;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blued.common.base.BaseActivity;
import com.blued.common.constants.ARouterConfig;

/**
 * @Author： ZhangYuLiang
 * @description：
 */

@Route(path = ARouterConfig.VIEW_ONE)
public class OneActivity extends BaseActivity {
    private View module2, module3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        ARouter.getInstance().inject(OneActivity.this);
    }

    private void initView() {
        module2 = findViewById(com.blued.c_module_main.R.id.bt_module2);
        module3 = findViewById(com.blued.c_module_main.R.id.bt_module3);
    }

    private void initListener() {

        module2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterConfig.VIEW_TWO).navigation();
                Toast.makeText(OneActivity.this, "two", Toast.LENGTH_SHORT).show();
            }
        });

        module3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConfig.VIEW_THREE).navigation();
                Toast.makeText(OneActivity.this, "three", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
