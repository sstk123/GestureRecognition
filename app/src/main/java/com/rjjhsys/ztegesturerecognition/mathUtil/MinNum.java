package com.rjjhsys.ztegesturerecognition.mathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by gongyan on 2016/10/23.
 */

public class MinNum {

    public static double getMinNum(ArrayList arrayList){
        ArrayList arrayList1 = new ArrayList();
        arrayList1 = (ArrayList) arrayList.clone();
        Collections.sort(arrayList1);

        return (double)arrayList1.get(0);
    }
    public static double getMinNum(double[] array){
        double[] array1 = array.clone();
        array1 = array.clone();
        Arrays.sort(array1);
        return array1[0];
    }
    public static double[] getMultiMinNum(double[] array,int num){
        double[] array1 = array.clone();
        array1 = array.clone();
        Arrays.sort(array1);
        double[] multiMin = new double[num];
        for (int i=0;i<num;i++){
            multiMin[i] = array1[i];
        }
        return multiMin;
    }
}
