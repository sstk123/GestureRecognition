package com.rjjhsys.ztegesturerecognition.OtherUtils;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/26.
 */
public class DataBox {
    public static double[] DataBoxHandle(double data[]) {
         //获取数组中的两个最值
        double[] data1 = data.clone();
        for (int j = 0; j < data1.length; j++) {
            if (Math.abs(data1[j])<0.2){
                data1[j] = 0.0;
            }else if (Math.abs(data1[j])<1){
                if (data1[j]>0){
                    data1[j] = 0.5;
                }else{
                    data1[j] = -0.5;
                }
            }else if (Math.abs(data1[j])<3){
                if (data1[j]>0){
                    data1[j] = 2.0;
                }else{
                    data1[j] = -2.0;
                }
            }else if (Math.abs(data1[j])<5){
                if (data1[j]>0){
                    data1[j] = 5.0;
                }else{
                    data1[j] = -5.0;
                }
            }else if (Math.abs(data1[j])>5){
                if (data1[j]>0){
                    data1[j] = 7.0;
                }else{
                    data1[j] = -7.0;
                }
            }
                    }
        return data1;
    }
    public static ArrayList DataBoxHandle(ArrayList data) {
        ArrayList data1 = (ArrayList) data.clone();
        ArrayList data2 = new ArrayList();
        for (int j = 0; j < data1.size(); j++) {
            if (Math.abs(Double.parseDouble( data1.get(j).toString()))<0.2){
                data2.add(0.0);
            }else if (Math.abs(Double.parseDouble( data1.get(j).toString()))<1){
                if (Double.parseDouble( data1.get(j).toString())>0){
                    data2.add(0.5);
                }else{
                    data2.add(-0.5);                }
            }else if (Double.parseDouble( data1.get(j).toString())<3){
                if (Double.parseDouble( data1.get(j).toString())>0){
                    data2.add(2.0);
                }else{
                    data2.add(-2.0);
                }
            }else if (Math.abs(Double.parseDouble( data1.get(j).toString()))<5){
                if (Double.parseDouble( data1.get(j).toString())>0){
                    data2.add(5.0);
                }else{
                    data2.add(-5.0);
                }
            }else if (Math.abs(Double.parseDouble( data1.get(j).toString()))>5){
                if (Double.parseDouble( data1.get(j).toString())>0){
                    data2.add(7.0);
                }else{
                    data2.add(-7.0);
                }
            }
        }
        return data2;
    }
}
