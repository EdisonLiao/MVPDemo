package com.example.edisonliao.mvpdemo.mvp;

/**
 * Created by EdisonLiao on 2017/9/23.
 * View层的 Base接口
 * 定义一些所有view共有的方法
 *
 */

public interface BaseView {
    void showLoading();

    void hideLoading();
}
