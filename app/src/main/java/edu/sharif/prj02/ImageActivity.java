package edu.sharif.prj02;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        ImageView img3 = findViewById(R.id.imageView3);
//        AnimatedVectorDrawableCompat avdc = AnimatedVectorDrawableCompat.create(getBaseContext(), R.drawable.avd);
//        img3.setImageDrawable(avdc);
//        avdc.start();

//        final ImageView img3 = findViewById(R.id.imageView3);
//        final AnimatedVectorDrawableCompat avdc = AnimatedVectorDrawableCompat.create(getBaseContext(), R.drawable.avd_endless_pin_jump);
//        img3.setImageDrawable(avdc);
//        avdc.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
//                                           @Override
//                                           public void onAnimationEnd(Drawable drawable) {
//                                               img3.post(()->avdc.start());
//                                           }
//                                       });
//        avdc.start();


        ImageView img3 = findViewById(R.id.imageView3);
        AnimationDrawable drawable = (AnimationDrawable) getResources().getDrawable(R.drawable.anim_list);
        img3.setImageDrawable(drawable);
        drawable.start();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                ImageView img = findViewById(R.id.imageView);
                Drawable d = img.getDrawable();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // d.setTint(Color.BLUE);
                    Drawable mWrappedDrawable = d.mutate();
                    mWrappedDrawable = DrawableCompat.wrap(mWrappedDrawable);
                    DrawableCompat.setTint(mWrappedDrawable, Color.BLUE);
                    DrawableCompat.setTintMode(mWrappedDrawable, PorterDuff.Mode.SRC_IN);

//                    int c1 = ContextCompat.getColor(getBaseContext(), R.color.colorPrimary);
//
//                    ObjectAnimator colorAnimator = ObjectAnimator.ofArgb(mWrappedDrawable, "tint",  Color.BLACK, c1);
//                    colorAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//                    colorAnimator.setDuration(1000);
//                    colorAnimator.start();
                }
            }
        });
    }

}
