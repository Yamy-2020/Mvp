package com.example.mvp.model;

import com.example.mvp.ApiService;
import com.example.mvp.base.BaseModel;
import com.example.mvp.bean.MainBean;
import com.example.mvp.net.MainCallBack;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void initData(MainCallBack<ArrayList<MainBean.DataBean.DatasBean>> back) {
        new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainBean mainBean) {
                        if (mainBean != null) {
                            back.onSuccess((ArrayList<MainBean.DataBean.DatasBean>) mainBean.getData().getDatas());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        back.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
