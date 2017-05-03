package com.anwesome.ui.collageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 03/05/17.
 */
public class CollageItem  extends View{
    private int rotIndex = 1,render = 0;
    private Bitmap bitmap;
    private AnimationHandler animationHandler;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public CollageItem(Context context,Bitmap bitmap,int rotIndex) {
        super(context);
        this.bitmap = bitmap;
        this.rotIndex = rotIndex;
        this.animationHandler = new AnimationHandler(this);
    }
    public void initXY(float x,float y) {
        if(render == 0) {
            setX(x);
            setY(y);
        }
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight();
        if(render == 0) {
            bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
        }
        DrawingUtil.drawCollageItemImage(canvas,paint,bitmap,w,h);
        render++;
    }
    public void update(float factor) {
        setRotation(45*rotIndex*factor);
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            if(getRotation()>=45) {
                animationHandler.end();
            }
            else {
                animationHandler.start();
            }
        }
        return true;
    }
}
