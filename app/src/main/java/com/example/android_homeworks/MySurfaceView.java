package com.example.android_homeworks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;
    private final Thread DrawThread;

    public MySurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        DrawThread = new DrawThread();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        this.surfaceHolder = holder;
        DrawThread.start();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    class DrawThread extends Thread {
        private volatile boolean running = true;
        private Canvas canvas;
        @Override
        public void run() {
            while (running) {
                try {
                    sleep(100);
                    canvas = surfaceHolder.lockCanvas();
                    canvas.drawColor(Color.BLUE);
                    if(circle != null && circle.x != circle.x1 && circle.y != circle.y1){
                        circle.draw(canvas);
                    }
                    surfaceHolder.unlockCanvasAndPost(canvas);
                    if(circle != null){
                        circle.update();
                    }
                } catch (Exception e) {
                }
            }

        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        circle = new MyCircle(event.getX(), event.getY());
        return super.onTouchEvent(event);
    }
     private  MyCircle circle;

    class MyCircle {
        float x1 = getWidth() / 2f, y1 = getHeight() / 2f, radius, x = x1, y = y1;
        Paint paint;


        public MyCircle(float x, float y) {
            this.x = x1;
            this.y = y1;
            this.x1 = x;
            this.y1 = y;
            this.radius = 50;
            paint = new Paint();
            paint.setColor(Color.RED);
        }

        void draw(Canvas canvas) {
            canvas.drawCircle(x, y, radius, paint);
        }

        void update() {
            float xv = x1 - x;
            float yv = y1 - y;
            double len = Math.sqrt((xv * xv) + (yv * yv));
            double xn1 = xv / len;
            double yn1 = yv / len;
            float xn = (float) xn1;
            float yn = (float) yn1;
            x += xn * 20;
            y += yn * 20;


        }
    }
}
