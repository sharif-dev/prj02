package edu.sharif.prj02;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // set main layout

        TextView title = findViewById(R.id.teTitle); // find component
        title.setText(R.string.title); // set string


        findViewById(R.id.btLinearLayout).setOnClickListener(
                (v)->{
                    Intent llActivity = new Intent(this, LinearActivity.class);
                    startActivity(llActivity);
                }
        );

        findViewById(R.id.btRelativeLayout).setOnClickListener(
                (v)->{
                    Intent llActivity = new Intent(this, RelativeLayoutActivity.class);
                    startActivity(llActivity);
                }
        );


        findViewById(R.id.button6).setOnClickListener(
                (v)->{
                    Intent llActivity = new Intent(this, ButtonActivity.class);
                    startActivity(llActivity);
                }
        );

        findViewById(R.id.button7).setOnClickListener(
                (v)->{
                    ObjectAnimator anim = ObjectAnimator.ofFloat(v, "rotation", 0f, 90f);
                    anim.setDuration(2000);                  // Duration in milliseconds
                    anim.setInterpolator(new BounceInterpolator());  // E.g. Linear, Accelerate, Decelerate
                    anim.start();

//                    AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.animator.first);
//                    set.setTarget(v);
//                    set.start();

                   // v.animate().setDuration(2000).scaleY(3).scaleX(3).start();
                }
        );

        findViewById(R.id.btNavToImgActivity).setOnClickListener((v)->{
            Intent llActivity = new Intent(this, ImageActivity.class);
            startActivity(llActivity);
        });
    }

    public static class ReverseInterpolator implements Interpolator {
        @Override
        public float getInterpolation(float paramFloat) {
            return Math.abs(paramFloat -1f);
        }
    }
}
