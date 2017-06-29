package com.rjjhsys.ztegesturerecognition.mathUtil;

import java.util.ArrayList;

/**
 * Created by gongyan on 2016/10/23.
 */

public class Energy {
    public static double getEnergy(ArrayList arrayList){

        double temp = 0;
        for(int i=0;i<arrayList.size();i++){
            temp += ((double) arrayList.get(i))*((double) arrayList.get(i));
        }

        return temp;

    }
    public static double getEnergy(double[] array){

        double temp = 0;
        for(int i=0;i<array.length;i++) {
            temp += ((double) array[i])*((double) array[i]);
        }
        return temp;
    }
}
