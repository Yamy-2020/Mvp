package com.example.mvp.model;

import com.example.mvp.ApiService;
import com.example.mvp.base.BaseModel;
import com.example.mvp.base.BaseSubscriber;
import com.example.mvp.bean.MainBean;
import com.example.mvp.net.MainCallBack;
import com.example.mvp.util.HttpUtil;
import com.example.mvp.util.RxUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void initData(MainCallBack<ArrayList<MainBean.DataBean.DatasBean>> back) {
//        addDisposable(new Retrofit.Builder()
//                .baseUrl(ApiService.url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//                .create(ApiService.class)
//                .getData()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new ResourceSubscriber<MainBean>() {
//                    @Override
//                    public void onNext(MainBean mainBean) {
//                        back.onSuccess((ArrayList<MainBean.DataBean.DatasBean>) mainBean.getData().getDatas());
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        back.onFail(t.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                }));
        addDisposable(HttpUtil.getInstance()
                .getApiService()
                .getData()
                .compose(RxUtils.<MainBean>rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<MainBean>() {
                    @Override
                    public void onNext(MainBean mainBean) {
                        back.onSuccess((ArrayList<MainBean.DataBean.DatasBean>) mainBean.getData().getDatas());
                    }
                }));
    }
}
