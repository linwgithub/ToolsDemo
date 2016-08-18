package com.linw.tudoulin.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linw.tudoulin.R;
import com.linw.tudoulin.base.MyBaseAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ShowHorizontalListView extends MyBaseAppCompatActivity {

    RecyclerView mListView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_horizontal_list_view);
        initActionBar();
        setTitle("HorizontalActivity");
        initData();

        mListView = (RecyclerView) findViewById(R.id.id_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mListView.setLayoutManager(layoutManager);
        mListView.setAdapter(mAdapter = new HomeAdapter());
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 12; i++)
        {
            mDatas.add("no." + i);
        }
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(
                    ShowHorizontalListView.this).inflate(R.layout.item_text_view, null,
                    false);

            MyViewHolder holder = new MyViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            holder.tv.setText(mDatas.get(position) + "");
        }

        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView tv;

            public MyViewHolder(View view)
            {
                super(view);
                this.tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }



}
