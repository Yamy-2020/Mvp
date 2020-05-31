package com.example.mvp;

import com.example.mvp.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String url = "https://www.wanandroid.com/";

    @GET("project/list/1/json?cid=0")
    Observable<MainBean> getData();
}
