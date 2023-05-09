package com.example.exercise4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {

    Bitmap[] frames = new Bitmap[16];

    int i = 0;
    long last_tick = 0;
    long period = 200;
    Context ctext;

    MediaPlayer mPlayer;

    public GraphicsView(Context context) {
        super(context);

        ctext = context;

        for (int i = 0; i < 6; i++) {
            int resourceId = getResources().getIdentifier("p" + (i + 1), "drawable", context.getPackageName());
            frames[i] = BitmapFactory.decodeResource(getResources(), resourceId);
        }

        // Initialize the MediaPlayer object with the audio file
        mPlayer = MediaPlayer.create(getContext(), R.raw.nothinonme);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (i < 16) {
            long time = (System.currentTimeMillis() - last_tick);
            if (time >= period) {
                last_tick = System.currentTimeMillis();
                canvas.drawBitmap(frames[i], 40, 40, new Paint());
                i++;
                postInvalidate();
            } else {
                canvas.drawBitmap(frames[i], 40, 40, new Paint());
                postInvalidate();
            }
        } else {
            i = 0;
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;

        // Start playing the audio when the user touches the screen
        if (!mPlayer.isPlaying()) {
            mPlayer.start();
        }

        return true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        // Release the MediaPlayer object when the view is detached from the window
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
}


