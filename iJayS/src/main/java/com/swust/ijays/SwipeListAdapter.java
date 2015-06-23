package com.swust.ijays;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by issjj7 on 2015/6/22.
 */
public class SwipeListAdapter extends BaseAdapter {

    private List<Movie> mList;
    private Activity mActivity;
    private LayoutInflater mInflater;
    private String[] bgColors;

    public SwipeListAdapter(Activity activity, List<Movie> mList) {
        this.mActivity = activity;
        this.mList = mList;
        bgColors = activity.getApplication().getResources().
                getStringArray(R.array.movie_serial_bg);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (mInflater == null)
            mInflater = (LayoutInflater) mActivity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = mInflater.inflate(R.layout.list_row, null);

        TextView serial = (TextView) convertView.findViewById(R.id.id_serial);
        TextView title = (TextView) convertView.findViewById(R.id.id_title);

        serial.setText(String.valueOf(mList.get(position).id));
        title.setText(mList.get(position).title);

        String color = bgColors[position % bgColors.length];
        serial.setBackgroundColor(Color.parseColor(color));

        return convertView;
    }

}
