package com.example.athyab.pikit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashPikIt extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_pik_it);

        textView = (TextView) findViewById(R.id.title);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Supercell-magic-webfont.ttf");
        textView.setTypeface(customFont);

        final ImageView imageView= (ImageView) findViewById(R.id.pikit);
        final Animation animation= AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        final Animation animation1= AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out);

        imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                imageView.startAnimation(animation1);
                finish();
                Intent intent = new Intent(SplashPikIt.this,MainActivity.class);
                startActivity(intent);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });




    }
}
