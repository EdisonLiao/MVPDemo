package com.example.edisonliao.mvpdemo.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.edisonliao.mvpdemo.R;
import com.example.edisonliao.mvpdemo.adapter.MainAdapter;
import com.example.edisonliao.mvpdemo.mvp.MainPresenter;
import com.example.edisonliao.mvpdemo.mvp.MainView;
import com.example.edisonliao.mvpdemo.mvp.model.MainModelResponse;
import com.example.edisonliao.mvpdemo.mvp.model.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    RecyclerView mRecyclerView;
    private ProgressDialog mProgressdialog;
    private MainPresenter mainPresenter;
    private MainAdapter mAdpter;
    private List<ResultsItem> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        mainPresenter.start("Android","10","1");
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        initRecyclerView();
    }

    private void initRecyclerView(){
        mList = new ArrayList<>();
        mAdpter = new MainAdapter(mList,this);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdpter);
    }

    @Override
    public void showLoading() {
        mProgressdialog = new ProgressDialog(MainActivity.this);
        mProgressdialog.setMessage("加载中");
        mProgressdialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressdialog != null && mProgressdialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            mProgressdialog.dismiss();
        }
    }

    @Override
    public void getMainModelData(MainModelResponse data) {
        Log.e("data",data.getResults().size()+"");
        mAdpter.update(data.getResults());
    }

    @Override
    public void getErrorMsg(String msg) {
        Log.e("error",msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }
}
