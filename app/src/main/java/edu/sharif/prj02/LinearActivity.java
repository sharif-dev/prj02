package edu.sharif.prj02;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

public class LinearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        findViewById(R.id.btAnim).setOnClickListener((v)->{
            AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.animator.first);
            set.setTarget(v);

            set.setInterpolator(new BounceInterpolator());
            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    v.setAlpha(1);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            set.start();
        });
    }

}
