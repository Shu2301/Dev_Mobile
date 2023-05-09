package com.example.exercise3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {

    Bitmap[] frames = new Bitmap[16];

    int i = 0;
    public GraphicsView(Context context) {
        super(context);

        for (int i = 0; i < 6; i++) {
            int resourceId = getResources().getIdentifier("psy" + (i + 1), "drawable", context.getPackageName());
            frames[i] = BitmapFactory.decodeResource(getResources(), resourceId);
        }
    }

    @Override
    protected void onDraw (Canvas canvas) {

        if (i < 16) {
            Bitmap frame = frames[i];
            float scale = Math.min((float) canvas.getWidth() / frame.getWidth(), (float) canvas.getHeight() / frame.getHeight());
            int width = (int) (frame.getWidth() * scale);
            int height = (int) (frame.getHeight() * scale);
            int left = (canvas.getWidth() - width) / 2;
            int top = (canvas.getHeight() - height) / 2;
            Rect dst = new Rect(left, top, left + width, top + height);
            canvas.drawBitmap(frame, null, dst, null);
        } else {
            i = 0;
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        return true;
    }

}
