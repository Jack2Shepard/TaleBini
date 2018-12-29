package com.jash.shepard.talebini;

import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ThirdActivity extends AppCompatActivity {
    private TextView zodiacSignText;
    private ImageView zodiacSignIcon;
    private ListView months_ListView;
    private String fname, lname;
    private String[] shamsiMonths, zodiacSigns;
    private int birthYear, birthMonth, index;
    private MyAdapter adapter;
    public static String myZodiacSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        BackGroundAnimation();
        getAndSetData();
        adapter = new MyAdapter(this, R.layout.row_layout, shamsiMonths);
        months_ListView.setAdapter(adapter);
    }

    public void getAndSetData() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,
                "fonts/adobe_arabic_shin.ttf",true);
        TypedArray icons = getResources().obtainTypedArray(R.array.zodiac_icons);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        shamsiMonths = getResources().getStringArray(R.array.shamsi_months);
        months_ListView = findViewById(R.id.months_ListView);
        zodiacSignText = findViewById(R.id.zodiac_Sign_Text);
        zodiacSignIcon = findViewById(R.id.zodiac_Icon);
        zodiacSigns = getResources().getStringArray(R.array.zodiac_signs);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            birthYear = extras.getInt("year");
            birthMonth = extras.getInt("month");
            fname = extras.getString("fname");
            lname = extras.getString("lname");
            getSupportActionBar().setTitle("خوش آمدی" + " " + fname);
            index = (birthYear - 6) % 12;
            myZodiacSign = zodiacSigns[index];
            zodiacSignText.setText("متولد سال" + " " + zodiacSigns[index]);
            zodiacSignIcon.setImageResource(icons.getResourceId(index, -1));
            icons.recycle();
        }
    }
    public void BackGroundAnimation(){
        RelativeLayout bg = findViewById(R.id.parent_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable)bg.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }
}
