package com.example.mvp.util;

import android.widget.Toast;

import com.example.mvp.base.BaseApp;

public class ToastUtil {
    public static void showToastShort(String msg){
        Toast.makeText(BaseApp.sContext,msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(String msg){
        Toast.makeText(BaseApp.sContext,msg, Toast.LENGTH_LONG).show();
    }
}

