package com.example.mvp.presenter;

import com.example.mvp.base.BasePresenter;
import com.example.mvp.bean.MainBean;
import com.example.mvp.model.MainModel;
import com.example.mvp.net.MainCallBack;
import com.example.mvp.view.MainView;

import java.util.ArrayList;

public class MainPresenter extends BasePresenter<MainView> {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        models.add(mainModel);
    }

    @Override
    public void initData() {
        mainModel.initData(new MainCallBack<ArrayList<MainBean.DataBean.DatasBean>>() {
            @Override
            public void onSuccess(ArrayList<MainBean.DataBean.DatasBean> datasBeans) {
                mView.setData(datasBeans);
            }

            @Override
            public void onFail(String string) {
                mView.showToast(string);
            }
        });
    }

}
