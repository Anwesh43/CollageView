package com.anwesome.ui.collageview;

import android.graphics.*;

/**
 * Created by anweshmishra on 03/05/17.
 */
public class DrawingUtil {
    public static void drawCollageItemImage(Canvas canvas,Paint paint,Bitmap bitmap,int w,int h) {
        Path path = new Path();
        path.moveTo(0,0);
        path.lineTo(w,0);
        int triSize = Math.min(w,h)/6;
        path.lineTo(w,h-triSize);
        path.lineTo(w-triSize,h);
        path.lineTo(0,h);
        path.lineTo(0,0);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,0,0,paint);
        paint.setColor(Color.parseColor("#9E9E9E"));
        Path newPath = new Path();
        newPath.moveTo(w-triSize,h-triSize);
        newPath.lineTo(w-triSize,h);
        newPath.lineTo(w,h-triSize);
        newPath.lineTo(w-triSize,h-triSize);
        canvas.drawPath(newPath,paint);
    }
}
