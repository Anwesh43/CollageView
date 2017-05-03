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
        int triSize = Math.min(w,h)/10;
        path.lineTo(w,h-triSize);
        path.lineTo(w-triSize,h);
        path.lineTo(0,h);
        path.lineTo(0,0);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,0,0,paint);
        paint.setColor(Color.parseColor("#757575"));
        canvas.drawPath(path,paint);
    }
}
