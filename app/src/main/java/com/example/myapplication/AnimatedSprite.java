package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class AnimatedSprite {
    private Bitmap bitmap;
    public int x;
    public int y;
    private int currentFrameX;
    public int currentFrameY;
    private Rect[][] frames = new Rect[4][4];

    public AnimatedSprite(Bitmap bitmap, int x, int y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        int imageSize = bitmap.getWidth() / 4;
        for (int i = 0; i < frames.length; i++) {
            for (int j = 0; j < frames[i].length; j++) {
                frames[i][j] = new Rect(
                        imageSize * j,
                        imageSize * i,
                        imageSize * (j + 1),
                        imageSize * (i + 1)
                );


            }
        }
    }

    public void update(Canvas canvas, Paint paint) {
        canvas.drawBitmap(
                bitmap,
                frames[currentFrameY][currentFrameX],
                new Rect(x, y, x + bitmap.getWidth() / 4, y + bitmap.getHeight() / 4),
                paint);
        currentFrameX = (currentFrameX + 1) % 4;
    }
}
