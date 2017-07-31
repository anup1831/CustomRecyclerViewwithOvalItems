package com.pathfinder.anup.listviewwithovalitems;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Anup on 7/27/2017.
 */

public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private List<String> stringList = new ArrayList<>();
    public CustomListAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return stringList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtTimeStamp = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String item = (String) getItem(position);
        //holder.txtTimeStamp.setOnClickListener(mItemViewClieckListener);
        final ViewHolder finalHolder = holder;
        holder.txtTimeStamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // finalHolder.txtTimeStamp.setBackgroundColor(Color.parseColor("#ff0000"));
                finalHolder.txtTimeStamp.setBackgroundResource(R.drawable.oval_red);
                finalHolder.txtTimeStamp.setEnabled(false);
                Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        holder.txtTimeStamp.setText(item);


        return convertView;
    }

    /*private View.OnClickListener mItemViewClieckListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show();


        }
    };*/

    private class ViewHolder {
       // ImageView imageView;
        //TextView txtTitle;
        TextView txtTimeStamp;

    }

}
