package com.example.mvp.base;

import java.util.ArrayList;

public abstract class BasePresenter<T extends BaseView> {

    public T mView;
    public ArrayList<BaseModel> models = new ArrayList<>();

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void bindView(T view) {
        mView = view;
    }

    public void addModel(BaseModel baseModel) {
        models.add(baseModel);
    }

    public void destory() {
        mView = null;
        for (int i = 0; i < models.size(); i++) {
            BaseModel baseModel = models.get(i);
            baseModel.onDestory();
        }
    }

    public abstract void initData();
}
