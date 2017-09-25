package com.example.edisonliao.mvpdemo.mvp;

import com.example.edisonliao.mvpdemo.mvp.model.MainModelResponse;

/**
 * Created by EdisonLiao on 2017/9/23.
 */

public interface MainView extends BaseView {

    void getMainModelData(MainModelResponse data);
    void getErrorMsg(String msg);
}
