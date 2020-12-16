package com.blued.b_module_one;

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
import com.blued.myunitydemo.PeopleProto;

/**
 * @Author： ZhangYuLiang
 * @description：
 */

@Route(path = ARouterConfig.VIEW_ONE)
public class OneActivity extends BaseActivity {
    private View module2, module3,moduleMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);
        initView();
        initCallBack();
        initListener();
    }

    private void initView() {
        module2 = findViewById(R.id.bt_module2);
        module3 = findViewById(R.id.bt_module3);
        moduleMain = findViewById(R.id.bt_module_main);

//        PeopleProto.People
    }

    private void initListener() {

        module2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterConfig.VIEW_TWO).navigation(OneActivity.this,callback);
            }
        });

        module3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConfig.VIEW_THREE).navigation(OneActivity.this,callback);
            }
        });

        moduleMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OneActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(OneActivity.this, "直接引用跳转", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(OneActivity.this, "组件没有找到", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onArrival(Postcard postcard) {
                Toast.makeText(OneActivity.this, "跳转成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterrupt(Postcard postcard) {

            }
        };
    }

}
