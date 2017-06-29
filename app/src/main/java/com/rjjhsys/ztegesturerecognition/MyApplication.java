package com.rjjhsys.ztegesturerecognition;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class MyApplication extends Application {
    private static Context context;
    public static double[][] o1, o2, o3, e1, e2, e3, v1, v2, v3, u1, u2, u3, w1, w2, w3, y1, y2, y3, c1, c2, c3;


    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();

    }
    public static Context getContext() {
        return context;
    }

}