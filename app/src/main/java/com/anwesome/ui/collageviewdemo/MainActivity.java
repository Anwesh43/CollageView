package com.anwesome.ui.collageviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.collageview.CollageUI;

public class MainActivity extends AppCompatActivity {
    private int images[] = {R.drawable.back1,R.drawable.back2,R.drawable.back3,R.drawable.back4};
    private Bitmap bitmaps[] = new Bitmap[images.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CollageUI collageUI = new CollageUI(this);
        int i = 0;
        for(int image:images) {
            bitmaps[i] = BitmapFactory.decodeResource(getResources(),image);
            i++;
        }
        for(Bitmap bitmap:bitmaps) {
            collageUI.addImage(bitmap);
        }
        collageUI.show();
    }
}
