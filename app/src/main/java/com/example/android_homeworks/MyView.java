package com.example.android_homeworks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View {
    private final Paint paint = new Paint();

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        //getContext().getResources().getColor(R.color.teal_200);
        paint.setColor(Color.RED);
        canvas.drawCircle(getWidth() / 2f, getHeight() / 2f, 50, paint);
        super.onDraw(canvas);
        for (Pair<Float, Float> coordinate : coordinates){
            canvas.drawCircle(coordinate.first, coordinate.second, 50, paint);
        }
    }

    private final List<Pair<Float, Float>> coordinates = new ArrayList<>();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        coordinates.add(new Pair<>(event.getX(), event.getY()));
        invalidate();

        return super.onTouchEvent(event);
    }
}
