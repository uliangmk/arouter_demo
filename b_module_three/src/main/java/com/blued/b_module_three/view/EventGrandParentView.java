package com.blued.b_module_three.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @Author： ZhangYuLiang
 * @description：
 */
public class EventGrandParentView extends FrameLayout {
    public EventGrandParentView(@NonNull Context context) {
        super(context);
    }

    public EventGrandParentView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventGrandParentView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("ulog", "dispatchTouchEvent " + ev.getAction() + "  ");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("ulog", "--onInterceptTouchEvent " + ev.getAction() + "  ");

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("ulog", "-----onTouchEvent " + event.getAction() + "  ");
        return super.onTouchEvent(event);
    }
}
