package com.rjjhsys.ztegesturerecognition.OtherUtils;

import java.util.ArrayList;

/**
 * Created by gongyan on 2017/6/7.
 */

public class ListToArray {
    public static double[] getArray(ArrayList list){
        double[] array = new double[list.size()];
        for (int i = 0;i<list.size();i++){
            array[i] = (double) list.get(i);
        }
        return array;
    }
}
