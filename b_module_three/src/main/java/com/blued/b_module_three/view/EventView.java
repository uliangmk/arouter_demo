package com.blued.b_module_three.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @Author： ZhangYuLiang
 * @description：
 */
public class EventView extends View {
    public EventView(@NonNull Context context) {
        super(context);
    }

    public EventView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }





    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("ulog","dispatchTouchEvent "+ev.getAction()+"  ");
        return super.dispatchTouchEvent(ev);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("ulog","-----onTouchEvent "+event.getAction()+"  ");
        return false;
    }


}
