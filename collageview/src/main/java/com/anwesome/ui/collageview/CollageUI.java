package com.anwesome.ui.collageview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 03/05/17.
 */
public class CollageUI {
    private List<CollageItem> collageItems = new ArrayList<>();
    private Activity activity;
    private RelativeLayout relativeLayout;
    private int w,h;
    public CollageUI(Activity activity) {
        this.activity = activity;
        initDimension();
    }
    private void initDimension() {
        DisplayManager displayManager = (DisplayManager)activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        Point size = new Point();
        display.getRealSize(size);
        w = size.x;
        h = 8*size.y/10;
    }
    public void show() {
        if(relativeLayout == null) {
            relativeLayout = new RelativeLayout(activity);
            int x = w/20,y = h/20;
            for(CollageItem collageItem:collageItems) {
                collageItem.initXY(x,y);
                relativeLayout.addView(collageItem,new ViewGroup.LayoutParams(2*w/5,2*h/5));
                x += ((2*w)/5)+w/10;
                if(x > w) {
                    x = w/20;
                    y += (2*h/5)+h/10;
                }
            }
            activity.setContentView(relativeLayout);
        }
    }
    public void addImage(Bitmap bitmap) {
        if(relativeLayout == null && collageItems.size() < 4) {
            int rotIndex = 1-2*(collageItems.size()%2);
            collageItems.add(new CollageItem(activity,bitmap,rotIndex));
        }
    }
}
