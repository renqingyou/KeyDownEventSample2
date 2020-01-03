package com.rqy.keydowneventsample2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        findViewById(R.id.custom1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("rqy", "MyLinearLayout button1 被点击了");
            }
        });
        findViewById(R.id.custom2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("rqy", "MyLinearLayout button2 被点击了");
            }
        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        //Log.e("rqy", "dispatchKeyEvent-a=" + a + "--" + this + event.getAction() + "-" + event.getKeyCode());
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
            for (int i = 0; i < this.getChildCount(); i++) {
                View view = this.getChildAt(i);
                if (view.hasFocus()) {
                    Button button = (Button) view;
                    Log.e("rqy","dispatchKeyEvent--MyLinearLayout--"+ button.getText().toString());
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /*for (int i = 0; i < this.getChildCount(); i++) {
            View view = this.getChildAt(i);
            if (view.hasFocus()) {
                Button button = (Button) view;
                Log.e("rqy", button.getText().toString());
            }
        }*/
        Log.e("rqy", "onKeyDown--MyLinearLayout--" + keyCode + "--" + this);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (int i = 0; i < this.getChildCount(); i++) {
                View view = this.getChildAt(i);
                if (isTouchPointInView(view, (int) event.getRawX(), (int) event.getRawY())) {
                    Button button = (Button) view;
                    Log.e("rqy", button.getText().toString());
                }
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * (x,y)是否在view的区域内
     *
     * @param view
     * @param x
     * @param y
     * @return
     */
    public boolean isTouchPointInView(View view, int x, int y) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();

        return y >= top && y < bottom && x >= left && x <= right;
    }
}
