package com.rjjhsys.ztegesturerecognition;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
//import android.support.multidex.MultiDexApplication;

import java.util.ArrayList;

public class MyApplication extends Application {
    private static Context context;
    public static double[][] o1, o2, o3, e1, e2, e3, v1, v2, v3, u1, u2, u3, w1, w2, w3, y1, y2, y3, c1, c2, c3;
    public static double[][] O1,O2,O3,O4,O5,O6,O7,O8,O9,O10,O11,O12,O13,O14,O15,O16,O17,O18,V1,V2,V3,V4,V5,V6,V7,V8,V9,V10,V11,V12,V13,V14,V15,V16,V17,V18,V19,V20,V21,V22,V23,V24;
    public static boolean createStatus;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();

    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    public static Context getContext() {
        return context;
    }

}