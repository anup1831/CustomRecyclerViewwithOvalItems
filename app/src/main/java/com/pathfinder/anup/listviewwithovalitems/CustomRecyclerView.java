package com.pathfinder.anup.listviewwithovalitems;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anup on 7/28/2017.
 */

/*public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.MyViewHolder> {

    RecyclerViewItemClickListener recyclerViewItemClickListener;
    private List<String> timeStampList = new ArrayList<>();
    private Context context;

    public CustomRecyclerView(List<String> timeStampList, Context context) {
        this.timeStampList = timeStampList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtTimeStamp;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtTimeStamp = (TextView) itemView.findViewById(R.id.textView);
            Log.i("Anup", " Adding Listener - "+"added");
            txtTimeStamp.setOnClickListener(this);

        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public void onClick(View view) {
            Log.i("Anup", " Clicked - "+getAdapterPosition());
            recyclerViewItemClickListener.onItemClickListener(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(RecyclerViewItemClickListener onItemClickListener){
        this.recyclerViewItemClickListener = onItemClickListener;
    }

    @Override
    public CustomRecyclerView.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomRecyclerView.MyViewHolder holder, int position) {
        if(timeStampList.size() > 0){
            holder.txtTimeStamp.setText(timeStampList.get(position));
        }

    }

    public void addItem(String item, int pos){
        timeStampList.add(item);
        notifyItemInserted(pos);
    }

    public void deleteItem(int pos){
        timeStampList.remove(pos);
        notifyItemRemoved(pos);
    }

    @Override
    public int getItemCount() {
        if(timeStampList.size() > 0){
            return timeStampList.size();
        } else {
        return 0;}
    }

    interface RecyclerViewItemClickListener{
        public void onItemClickListener(int position, View view);
    }
}*/

public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.ViewHolder> {
    private Context context;
    private List<String> stringList = new ArrayList<>();
    private LayoutInflater mInflater;
    String item = new String();

    public CustomRecyclerView(List<String> stringList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.stringList = stringList;
        setHasStableIds(true);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // RecyclerView.ViewHolder view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        item = stringList.get(position);
        if(item != null){
            viewHolder.txtTimeStamp.setText(item);
        }
    }

    @Override
    public int getItemCount() {
        if(stringList != null){
           return stringList.size();
        } else {
        return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtTimeStamp;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTimeStamp = (TextView) itemView.findViewById(R.id.textView);
            txtTimeStamp.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            txtTimeStamp.setBackgroundResource(R.drawable.oval_red);
            txtTimeStamp.setEnabled(false);
            Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
