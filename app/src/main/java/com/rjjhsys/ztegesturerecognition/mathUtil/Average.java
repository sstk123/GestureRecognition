package com.rjjhsys.ztegesturerecognition.mathUtil;

import java.util.ArrayList;

/**
 * get array or arraylist average
 * Created by gongyan on 2016/10/23.
 */

public class Average {

    public static double getAverage(double[] dataArray){

        double result = 0;
        for (int i=0;i<dataArray.length;i++){

            result+=dataArray[i];

        }
      return result/dataArray.length;
    }

    public static double getAverage(ArrayList<Double> dataArray){

        double result = 0;
        for (int i=0;i<dataArray.size();i++){

            result+=dataArray.get(i);

        }
        return result/dataArray.size();
    }
}
