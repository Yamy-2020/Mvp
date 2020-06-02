package com.example.mvp.base;

public interface BaseView {
    void showToast(String string);
    //弹loading
    void showLoading();

    //隐藏loading
    void hideLoading();
}
