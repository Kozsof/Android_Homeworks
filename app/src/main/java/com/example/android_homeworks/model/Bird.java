package com.example.android_homeworks.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.android_homeworks.R;

public class Bird extends GameObject {
    private Bitmap sprite;
    private final Bitmap up;
    private final Bitmap straight;
    private final Bitmap down;
    private float ySpeed = 0;
    private static final float Y_ACCELEBRATION = 2f;


    public Bitmap getSprite() {
        return sprite;
    }

    public Bird(Context context, float x, float y) {
        super(x, y);
        up = BitmapFactory.decodeResource(context.getResources(), R.drawable.bluebird_2);
        straight = BitmapFactory.decodeResource(context.getResources(), R.drawable.bluebird_1);
        down = BitmapFactory.decodeResource(context.getResources(), R.drawable.bluebird_3);
        sprite = straight;

    }
    public void fly(){
        ySpeed = -30;
    }
    @Override
    public void update(){
        y += ySpeed;
        ySpeed += Y_ACCELEBRATION;
        if(ySpeed <-20) sprite = down;
        else if (ySpeed > 20) sprite = up;
        else sprite = straight;
    }

}
