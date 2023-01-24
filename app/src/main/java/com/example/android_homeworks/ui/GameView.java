package com.example.android_homeworks.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.android_homeworks.R;
import com.example.android_homeworks.model.Bird;
import com.example.android_homeworks.model.Pipe;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private static final int FPS = 300;
    private SurfaceHolder surfaceHolder;
    private DrawTread drawTread;
    private final Bitmap background;
    private Bird bird;
    private Pipe pipe;

    public GameView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.back);
        drawTread = new DrawTread();
        getHolder().addCallback(this);

    }

    private void init(){
        bird = new Bird(getContext(), 200, getHeight() / 2f);
        pipe = new Pipe(getContext(), getHeight(), getWidth());

    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        init();
        drawTread.start();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    private void drawFrames(Canvas canvas) {
        Rect backgroundRect = new Rect(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(background, null, backgroundRect, null);
        canvas.drawBitmap(bird.getSprite(), bird.x, bird.y, null);
        canvas.drawBitmap(pipe.getTopPipe(), pipe.x, 0, null);
        canvas.drawBitmap(pipe.getBottomPipe(), pipe.x, getHeight() - pipe.getBottomPipe().getHeight(), null);

    }

    private void update() {
        bird.update();
        pipe.update();
        if (pipe.isCollishion(bird) || bird.y <= 0 || bird.y >= getHeight()){
            drawTread.running = false;
       }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        bird.fly();
        if(!drawTread.running){
            drawTread = new DrawTread();
            init();
            drawTread.start();
        }
        return super.onTouchEvent(event);
    }

    private class DrawTread extends Thread {
        private volatile boolean running = true;

        @Override
        public void run() {
            Canvas canvas;
            while (running) {
                canvas = surfaceHolder.lockCanvas();
                try {
                    sleep(1000 / FPS);
                    drawFrames(canvas);
                    update();
                } catch (Exception e) {
                    Log.e("RRR", "run: ", e);
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }

            }
        }
    }
}
