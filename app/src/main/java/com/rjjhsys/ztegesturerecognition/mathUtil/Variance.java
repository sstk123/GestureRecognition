package com.rjjhsys.ztegesturerecognition.mathUtil;

import java.util.ArrayList;

/**
 * Created by gongyan on 2017/5/31.
 *是均方差  和方差有区别
 */

public class Variance {
    public static double getVariance(double[] data){
        double average =  Average.getAverage(data);
        double temp = 0;
        for(int i=0;i<data.length;i++) {

            temp += ((double) data[i]-average)*((double) data[i]-average);
        }
        return temp/(data.length-1);
    }

    public static double getVariance(ArrayList data){
        double average =  Average.getAverage(data);
        double temp = 0;
        for(int i=0;i<data.size();i++) {

            temp += ((double) data.get(i)-average)*((double) data.get(i)-average);
        }
        return temp/(data.size()-1);
    }
}
