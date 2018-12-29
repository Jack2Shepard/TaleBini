package com.jash.shepard.talebini;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;
import me.anwarshahriar.calligrapher.Calligrapher;

public class SecondActivity extends Activity {
    private EditText fName, lName;
    private TextView show_picked_date;
    private Button pick_Bdate, register;
    private String sendFname, sendLname;
    private PersianDatePickerDialog mPersianDatePickerDialog;
    private int bYear, bMonth, bDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        BackGroundAnimation();
        findViews();
        registerUser();
    }

    public void findViews() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(SecondActivity.this,
                "fonts/adobe_arabic_shin.ttf",true);
        fName = findViewById(R.id.fName_Ed);
        lName = findViewById(R.id.lName_Ed);
        pick_Bdate = findViewById(R.id.pick_birth_date);
        show_picked_date = findViewById(R.id.show_picked_date);
        register = findViewById(R.id.register_Btn);

    }

    public void registerUser() {
        pick_Birth_Date();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fName.getText().toString().length() <= 0) {
                    Toast.makeText(SecondActivity.this, "اسمت یادت رفت!",
                            Toast.LENGTH_SHORT).show();
                } else if (lName.getText().toString().length() <= 0) {
                    Toast.makeText(SecondActivity.this, "پس فامیلیت چی؟!",
                            Toast.LENGTH_SHORT).show();
                } else if (show_picked_date.length() <= 0) {
                    Toast.makeText(SecondActivity.this, "تاریخ تولد یادت رفت!",
                            Toast.LENGTH_SHORT).show();
                    pick_Birth_Date();
                } else {
                    sendFname = fName.getText().toString();
                    sendLname = lName.getText().toString();
                    pick_Birth_Date();
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("year", bYear);
                    intent.putExtra("month", bMonth);
                    intent.putExtra("day", bDay);
                    intent.putExtra("fname", sendFname);
                    intent.putExtra("lname", sendLname);
                    startActivity(intent);
                }
            }
        });
    }

    public void pick_Birth_Date() {
        pick_Bdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface typeface = Typeface.createFromAsset(getAssets(),
                        "fonts/adobe_arabic_shin.ttf");
                mPersianDatePickerDialog = new PersianDatePickerDialog(SecondActivity.this)
                        .setPositiveButtonString("تایید")
                        .setNegativeButton("لغو")
                        .setTodayButton("امروز")
                        .setTodayButtonVisible(true)
                        .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                        .setMinYear(1300)
                        .setTitleColor(Color.DKGRAY)
                        .setActionTextColor(Color.DKGRAY)
                        .setTypeFace(typeface)
                        .setBackgroundColor(Color.TRANSPARENT)
                        .setPickerBackgroundColor(Color.TRANSPARENT)
                        .setTitleColor(Color.DKGRAY)
                        .setListener(new Listener() {
                            @Override
                            public void onDateSelected(PersianCalendar persianCalendar) {
                                bYear = persianCalendar.getPersianYear();
                                bMonth = persianCalendar.getPersianMonth();
                                bDay = persianCalendar.getPersianDay();
                                show_picked_date.setVisibility(View.VISIBLE);
                                YoYo.with(Techniques.Flash)
                                        .duration(700)
                                        .repeat(0)
                                        .playOn(show_picked_date);
                                show_picked_date.setText("تاریخ تولد : " + bYear + "/" +
                                        bMonth + "/" + bDay);
                            }

                            @Override
                            public void onDismissed() {

                            }
                        });

                mPersianDatePickerDialog.show();
            }
        });
    }
    public void BackGroundAnimation(){
        RelativeLayout bg = findViewById(R.id.first_act);
        AnimationDrawable animationDrawable = (AnimationDrawable)bg.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }
}
