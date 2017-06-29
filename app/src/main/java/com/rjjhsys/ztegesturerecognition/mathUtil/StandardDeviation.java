package com.rjjhsys.ztegesturerecognition.mathUtil;

import java.util.ArrayList;


public class StandardDeviation {

    public static double getStandarDeviation(ArrayList arrayList){

        double average =  Average.getAverage(arrayList);
        double temp = 0;
        for(int i=0;i<arrayList.size();i++)
        {
            temp += ((double) arrayList.get(i)-average)*((double) arrayList.get(i)-average);
        }
        return Math.sqrt(temp/(arrayList.size()-1));
    }
    public static double getStandarDeviation(double[] array){

        double average =  Average.getAverage(array);
        double temp = 0;
        for(int i=0;i<array.length;i++) {

            temp += ((double) array[i]-average)*((double) array[i]-average);
        }
        return Math.sqrt(temp/(array.length-1));

    }
}
