package com.rjjhsys.ztegesturerecognition.mathUtil;

import java.util.ArrayList;

/**
 * Created by gongyan on 2017/7/4.
 */

public class Standardlization {

    public static double[] getStandardlization(double[] data){
        double mean = Average.getAverage(data);
        double std = StandardDeviation.getStandarDeviation(data);
        for (int i=0;i<data.length;i++){
            data[i] = (data[i]-mean)/std;
        }
        return data;
    }

    public static ArrayList getStandardlization(ArrayList data){
        double mean = Average.getAverage(data);
        double std = StandardDeviation.getStandarDeviation(data);
        for (int i=0;i<data.size();i++){
            data.set(i,( (Double.parseDouble(data.get(i).toString())-mean)/std)) ;
        }
        return data;
    }
}
