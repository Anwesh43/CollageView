package com.anwesome.ui.collageview;

import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 03/05/17.
 */
public class AnimationHandler implements ValueAnimator.AnimatorUpdateListener{
    private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
    {{
        startAnim.setDuration(500);
        endAnim.setDuration(500);
        startAnim.addUpdateListener(this);
        endAnim.addUpdateListener(this);
    }}
    private CollageItem collageItem;
    public AnimationHandler(CollageItem collageItem) {
        this.collageItem = collageItem;
    }
    public void start() {
        startAnim.start();
    }
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float factor = (float)valueAnimator.getAnimatedValue();
        collageItem.update(factor);
    }
    public void end() {
        endAnim.start();
    }
}
