package com.jash.shepard.talebini;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import me.anwarshahriar.calligrapher.Calligrapher;

public class MyAdapter extends ArrayAdapter<String> implements View.OnClickListener {
    private Context mContext;
    private String[] months;
    private int lastposition = -1;

    private static class ViewHolder {
        TextView months_tv;
        ImageView months_icon;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        String birthMonth = getItem(position);
        switch (v.getId()) {
            case R.id.month_icon:
            case R.id.list_item_tv: {
                Intent intent = new Intent(mContext, FinalActivity.class);
                intent.putExtra("month", birthMonth);
                mContext.startActivity(intent);
                break;
            }
        }
    }

    public MyAdapter(@NonNull Context context, int resource, @NonNull String[] months) {
        super(context, resource, months);
        this.mContext = context;
        this.months = months;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(),
                "fonts/adobe_arabic_shin.ttf");
        ViewHolder holder;
        String month_name = getItem(position);
        final View result;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_layout, parent, false);
            holder.months_tv = convertView.findViewById(R.id.list_item_tv);
            holder.months_icon = convertView.findViewById(R.id.month_icon);
            result = convertView;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(mContext,
                position > lastposition ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.setAnimation(animation);
        lastposition = position;
        TypedArray mIcons = mContext.getResources().obtainTypedArray(R.array.months_icons);
        holder.months_tv.setText(month_name);
        holder.months_tv.setTypeface(typeface);
        holder.months_icon.setImageResource(mIcons.getResourceId(position, -1));
        holder.months_icon.setOnClickListener(this);
        holder.months_icon.setTag(position);
        return convertView;
    }
}
