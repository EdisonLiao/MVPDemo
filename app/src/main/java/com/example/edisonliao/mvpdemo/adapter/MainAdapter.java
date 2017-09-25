package com.example.edisonliao.mvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edisonliao.mvpdemo.R;
import com.example.edisonliao.mvpdemo.mvp.model.ResultsItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by EdisonLiao on 2017/9/23.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyHolder> {

    private List<ResultsItem> mList;
    private Context mContext;

    public MainAdapter(List<ResultsItem> list,Context context){
        mList = list;
        mContext = context;
    }

    public void update(List<ResultsItem> list){
        mList.addAll(list);
        notifyItemRangeChanged(0,list.size());
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        ResultsItem data = mList.get(position);
        Glide.with(mContext).load(R.drawable.timg).into(holder.imageView);
        holder.decTv.setText(data.getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView decTv;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.img_view);
            decTv = (TextView)itemView.findViewById(R.id.dec_tv);
        }
    }


}
