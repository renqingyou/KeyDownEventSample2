package com.rqy.keydowneventsample2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            android.view.View v = getWindow().getDecorView().findFocus();
            Log.e("rqy", "MainActivity-onKeyDown-" + v);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        android.view.View v = getWindow().getDecorView().findFocus();
        Log.e("rqy", "MainActivity-dispatchTouchEvent-" + v);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_CENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
            android.view.View v = getWindow().getDecorView().findFocus();
            Log.e("rqy", "MainActivity-dispatchKeyEvent-" + v);
        }
        return super.dispatchKeyEvent(event);
    }

    public void trackViewOnClick(Activity activity, KeyEvent event){
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_CENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
            android.view.View v = activity.getWindow().getDecorView().findFocus();
            Log.e("rqy", "MainActivity-dispatchKeyEvent-" + v);
        }
    }

}
