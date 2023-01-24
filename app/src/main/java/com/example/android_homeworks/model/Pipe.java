package com.example.android_homeworks.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.android_homeworks.R;

public class Pipe extends GameObject {
    private Bitmap topPipe;
    private Bitmap bottomPipe;
    private int score = 0;

    private static final float X_SPEED = 10;
    private static final float SPACER_SIZE = 200;

    private float ySpacer;
    private final float height;
    private final float width;


    public int getScore() {
        return score;
    }

    public Pipe(Context context, float height, float width) {
        super(width, 0);
        this.height = height;
        this.width = width;
        topPipe = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe_rotated);
        bottomPipe = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe);
        generatePipes();

    }
    public Bitmap getTopPipe() {
        return topPipe;
    }

    public Bitmap getBottomPipe() {
        return bottomPipe;
    }

    private void generatePipes() {
        y = random(height / 4f, height * 3 / 4f);

        topPipe = Bitmap.createScaledBitmap(topPipe, 100, (int) (y - SPACER_SIZE), false);
        bottomPipe = Bitmap.createScaledBitmap(bottomPipe, 100, (int) (height - y - SPACER_SIZE), false);


    }
    @Override
    public void update(){
        x -= X_SPEED;
        if(x <= -bottomPipe.getWidth()){
            x = width;
            score += 1;
            generatePipes();
        }
    }

    public boolean isCollishion(GameObject object){
        if (x - 85 < object.x && x + bottomPipe.getWidth() > object.x) {
            if (object.y - 10 < topPipe.getHeight()) {
                return true;
            }
            return object.y + 5  > height - bottomPipe.getHeight();
        }
           return false;
    }

    private float random(float min, float max) {
        return (float) (min + (Math.random() * (max - min)));
    }

}
