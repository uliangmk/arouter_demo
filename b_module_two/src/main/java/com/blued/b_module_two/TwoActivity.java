package com.blued.b_module_two;

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
@Route(path = ARouterConfig.VIEW_TWO)
public class TwoActivity extends BaseActivity {
    private View module1, module3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
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
                ARouter.getInstance().build(ARouterConfig.VIEW_ONE).navigation();
                Toast.makeText(TwoActivity.this, "two", Toast.LENGTH_SHORT).show();
            }
        });

        module3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConfig.VIEW_THREE).navigation();
                Toast.makeText(TwoActivity.this, "three", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
