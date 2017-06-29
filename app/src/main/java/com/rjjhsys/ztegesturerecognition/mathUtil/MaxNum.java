package com.rjjhsys.ztegesturerecognition.mathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by gongyan on 2016/10/23.
 */

public class MaxNum {
    public static double getMaxNum(ArrayList arrayList){
        ArrayList arrayList1 = new ArrayList();
                arrayList1 = (ArrayList) arrayList.clone();
        Collections.sort(arrayList1);

        return (double)arrayList1.get(arrayList1.size()-1);
    }
    public static double getMaxNum(double[] array){
        double[] array1 = new double[array.length];
        array1 = array.clone();
        Arrays.sort(array1);
        return array1[array1.length-1];
    }
}
