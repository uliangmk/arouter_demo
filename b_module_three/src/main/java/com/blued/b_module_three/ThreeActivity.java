package com.blued.b_module_three;

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
@Route(path = ARouterConfig.VIEW_THREE)
public class ThreeActivity extends BaseActivity {
    private View module1, module2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        module1 = findViewById(com.blued.c_module_main.R.id.bt_module1);
        module2 = findViewById(com.blued.c_module_main.R.id.bt_module2);
    }

    private void initListener() {
        module1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterConfig.VIEW_ONE).navigation();
                Toast.makeText(ThreeActivity.this, "two", Toast.LENGTH_SHORT).show();
            }
        });

        module2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConfig.VIEW_TWO).navigation();
                Toast.makeText(ThreeActivity.this, "three", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
