package com.jash.shepard.talebini;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import me.anwarshahriar.calligrapher.Calligrapher;


public class FinalActivity extends AppCompatActivity implements View.OnClickListener{
    private Button maleButton,femaleButton;
    private String zodiac_Year = ThirdActivity.myZodiacSign , birthMonth;
    private TextView horoscope_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        BackGroundAnimation();
        initiateViews();
    }

    public void initiateViews(){
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,
                "fonts/adobe_arabic_shin.ttf",true);
        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            birthMonth = extras.getString("month");
            getSupportActionBar().setTitle("متولد" + " " + birthMonth + " " + "سال" + " " + zodiac_Year);
        }
        maleButton = findViewById(R.id.male_btn);
        femaleButton = findViewById(R.id.female_btn);
        horoscope_tv = findViewById(R.id.horoscope_tv);
        maleButton.setOnClickListener(this);
        femaleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.female_btn:{
                showFemaleHoroscope();
            }
            break;
            case R.id.male_btn :{
                showMaleHoroscope();
            }
            break;
            default:
                break;
        }

    }
    public void showMaleHoroscope(){
        String[] male_Horoscope = getResources().getStringArray(R.array.male_horoscope);
        switch (birthMonth){
            case "فروردین":
                horoscope_tv.setText(male_Horoscope[0]);
                break;
            case "اردیبهشت":
                horoscope_tv.setText(male_Horoscope[1]);
                break;
            case "خرداد":
                horoscope_tv.setText(male_Horoscope[2]);
                break;
            case "تیر":
                horoscope_tv.setText(male_Horoscope[3]);
                break;
            case "مرداد":
                horoscope_tv.setText(male_Horoscope[4]);
                break;
            case "شهریور":
                horoscope_tv.setText(male_Horoscope[5]);
                break;
            case "مهر":
                horoscope_tv.setText(male_Horoscope[6]);
                break;
            case "آبان":
                horoscope_tv.setText(male_Horoscope[7]);
                break;
            case "آذر":
                horoscope_tv.setText(male_Horoscope[8]);
                break;
            case "دی":
                horoscope_tv.setText(male_Horoscope[9]);
                break;
            case "بهمن":
                horoscope_tv.setText(male_Horoscope[10]);
                break;
            default:
                horoscope_tv.setText(male_Horoscope[11]);
                break;
        }
        YoYo.with(Techniques.SlideInLeft)
                .duration(700)
                .repeat(0)
                .playOn(horoscope_tv);
    }

    public void showFemaleHoroscope(){
        String[] female_Horoscope = getResources().getStringArray(R.array.female_horoscope);
        switch (birthMonth){
            case "فروردین":
                horoscope_tv.setText(female_Horoscope[0]);
                break;
            case "اردیبهشت":
                horoscope_tv.setText(female_Horoscope[1]);
                break;
            case "خرداد":
                horoscope_tv.setText(female_Horoscope[2]);
                break;
            case "تیر":
                horoscope_tv.setText(female_Horoscope[3]);
                break;
            case "مرداد":
                horoscope_tv.setText(female_Horoscope[4]);
                break;
            case "شهریور":
                horoscope_tv.setText(female_Horoscope[5]);
                break;
            case "مهر":
                horoscope_tv.setText(female_Horoscope[6]);
                break;
            case "آبان":
                horoscope_tv.setText(female_Horoscope[7]);
                break;
            case "آذر":
                horoscope_tv.setText(female_Horoscope[8]);
                break;
            case "دی":
                horoscope_tv.setText(female_Horoscope[9]);
                break;
            case "بهمن":
                horoscope_tv.setText(female_Horoscope[10]);
                break;
            default:
                horoscope_tv.setText(female_Horoscope[11]);
                break;
        }
        YoYo.with(Techniques.RollIn)
                .duration(700)
                .repeat(0)
                .playOn(horoscope_tv);
    }
    public void BackGroundAnimation(){
        RelativeLayout bg = findViewById(R.id.final_act);
        AnimationDrawable animationDrawable = (AnimationDrawable)bg.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }
}
