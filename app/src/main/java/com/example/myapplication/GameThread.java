package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private Context context;
    private boolean running;
    public AnimatedSprite mario;

    public GameThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        this.running = true;
        this.context = context;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.mario_spritesheet);
        mario = new AnimatedSprite(bitmap, 0, 0);
    }

    public void stopGame() {
        running = false;
    }

    @Override
    public void run() {

        Paint imagePaint = new Paint();

        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), imagePaint);
                mario.update(canvas, imagePaint);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            mario.x += 10;
            mario.y += 10;
        }
    }
}
