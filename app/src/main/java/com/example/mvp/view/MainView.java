package com.example.mvp.view;

import com.example.mvp.base.BaseView;
import com.example.mvp.bean.MainBean;

import java.util.ArrayList;

public interface MainView extends BaseView {
    void setData(ArrayList<MainBean.DataBean.DatasBean> datasBeans);
}
