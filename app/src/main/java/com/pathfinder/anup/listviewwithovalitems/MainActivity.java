package com.pathfinder.anup.listviewwithovalitems;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.manageSpaceActivity;
import static android.R.attr.offset;
import static android.R.attr.radius;
import static android.R.attr.x;
import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    CustomListAdapter listAdapter;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView recyclerView;
    ListView listView;
    List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);
        stringList =  new ArrayList<String>();
        stringList.add("India");
        stringList.add("Japan");
        stringList.add("States");
        stringList.add("Mangolia");
        stringList.add("Tiwaan");
        stringList.add("Korea");
        stringList.add("Indonesia");
        stringList.add("Jamshedpur");

        //listView = (ListView) findViewById(R.id.list_view);
        //listAdapter = new CustomListAdapter(getApplicationContext(), stringList);
        //listView.setAdapter(listAdapter);
        //listAdapter.notifyDataSetChanged();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new CustomRecyclerView(stringList, getApplicationContext());
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        /*RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);*/


    }

    /*@Override
    protected void onResume() {
        super.onResume();
        ((CustomRecyclerView) mAdapter).setOnItemClickListener(new CustomRecyclerView.RecyclerViewItemClickListener() {
            @Override
            public void onItemClickListener(int position, View view) {
                Log.i("Anup", "MainActivity - view pos "+position);
            }
        });
    }*/
}
