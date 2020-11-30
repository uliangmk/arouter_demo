package com.blued.common.base;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

//import com.alibaba.android.arouter.launcher.ARouter;
import com.blued.common.R;


public abstract class BaseActivity extends FragmentActivity {

    private FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.x_module_common_activity_base);
        container = findViewById(R.id.fl_container);
    }

    /**
     * 供子类调用
     */
    @Override
    public void setContentView(int layoutResID) {
        View childView = getLayoutInflater().inflate(layoutResID, null);
        container.addView(childView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    }
}
