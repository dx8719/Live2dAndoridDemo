package com.live2d.demo;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.view.*;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

public class FloatingService extends Service {
    public static boolean isStarted = false;

    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;

    private View top;

    @Override
    public void onCreate() {
        super.onCreate();
        isStarted = true;
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        }

        layoutParams.format = PixelFormat.RGBA_8888;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        layoutParams.width = 400;
        layoutParams.height = 400;
        layoutParams.x = 0;
        layoutParams.y = 0;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showFloatingWindow();
        return super.onStartCommand(intent, flags, startId);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void showFloatingWindow() {
        if (Settings.canDrawOverlays(this)) {
            RelativeLayout layout = new RelativeLayout(getApplicationContext());
            layout.addView(MainActivity.glView);
            windowManager.addView(layout, layoutParams);
            layout.setOnTouchListener(new FloatingOnTouchListener());

            scaleGestureDetector = new ScaleGestureDetector(layout.getContext(), new MySimpleScaleOnGestureDetector());
        }
    }

    ScaleGestureDetector scaleGestureDetector;
    float scaleFactor;

    class MySimpleScaleOnGestureDetector extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private final int width = 150;
        private final int height = 400;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor();
            scaleFactor = scaleFactor < 1 ? (float) 1 : scaleFactor > 3 ? 3 : scaleFactor;

            layoutParams.width = (int) (width * scaleFactor);
            layoutParams.height = (int) (height * scaleFactor);
            return true;
        }
    }

    private class FloatingOnTouchListener implements View.OnTouchListener {
        private int x;
        private int y;

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            top = view;
            int pointerCount = event.getPointerCount();
            if (pointerCount == 1) {
                MainActivity.glView.myTouchListener.onTouch(view, event);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getRawX();
                        y = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int nowX = (int) event.getRawX();
                        int nowY = (int) event.getRawY();
                        int movedX = nowX - x;
                        int movedY = nowY - y;
                        x = nowX;
                        y = nowY;
                        layoutParams.x = layoutParams.x + movedX;
                        layoutParams.y = layoutParams.y + movedY;
                        windowManager.updateViewLayout(view, layoutParams);
                        break;
                    default:
                        break;
                }
            } else if (pointerCount == 2) {
                scaleGestureDetector.onTouchEvent(event);    //双指缩放
            }
            return false;
        }
    }
}
