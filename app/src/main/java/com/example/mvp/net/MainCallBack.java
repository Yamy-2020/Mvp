package com.example.mvp.net;

public interface MainCallBack<T> {
    void onSuccess(T t);
    void onFail(String string);
}
