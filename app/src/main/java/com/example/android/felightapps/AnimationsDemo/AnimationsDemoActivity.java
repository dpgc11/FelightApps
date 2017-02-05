package com.example.android.felightapps.AnimationsDemo;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.android.felightapps.R;

public class AnimationsDemoActivity extends AppCompatActivity {

    private ImageView mImageToAnimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations_demo);

        mImageToAnimate = (ImageView) findViewById(R.id.iv_image_to_animate);
    }

    public void doAnimation(View view) {
        Animation animation;

        switch (view.getId()) {
            case R.id.btn_rotate:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                mImageToAnimate.startAnimation(animation);
                break;
            case R.id.btn_alpha:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                mImageToAnimate.startAnimation(animation);
                break;
            case R.id.btn_move_x:
                ObjectAnimator moveXAnimation = ObjectAnimator.ofFloat(mImageToAnimate, "translationX", 0,-360,0,360,-90,0,90,0,-180,0,180,0);
                moveXAnimation.setDuration(5000);
                moveXAnimation.start();
                break;
            case R.id.btn_move_y:
                ObjectAnimator moveYAnimation = ObjectAnimator.ofFloat(mImageToAnimate, "translationY", 0,-360,0,360,-90,0,90,0,-180,0,180,0);
                moveYAnimation.setDuration(5000);
                moveYAnimation.start();
                break;
            case R.id.btn_shake:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                mImageToAnimate.startAnimation(animation);
                break;
            case R.id.btn_wobble:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble);
                animation.reset();
                animation.setFillAfter(true);
                mImageToAnimate.startAnimation(animation);
                break;
        }

    }
}
