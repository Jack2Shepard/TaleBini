package com.jash.shepard.talebini;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import me.anwarshahriar.calligrapher.Calligrapher;

public class SplashScreen extends Activity {
    private static final int SPLASH_TIME_OUT = 2000;
    private ImageView logo;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(SplashScreen.this,
                "fonts/adobe_shin_stouts.ttf",true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo = findViewById(R.id.splash_logo);
                title = findViewById(R.id.title_sp);
                YoYo.with(Techniques.RotateOutUpRight)
                        .duration(2000)
                        .repeat(0)
                        .playOn(logo);
                YoYo.with(Techniques.RubberBand)
                        .duration(2000)
                        .repeat(0)
                        .playOn(title);
                startActivity(new Intent(SplashScreen.this,SecondActivity.class));
            }
        },SPLASH_TIME_OUT);

    }
}

