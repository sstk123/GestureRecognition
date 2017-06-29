package com.rjjhsys.ztegesturerecognition.mathUtil;

import java.util.ArrayList;

/**
 * Created by gongyan on 2017/6/5.
 * 瀵规暟鎹彇鍙嶏紝鍗虫璐熷彇鍙�
 */

public class ReverseData {
    public static double[] getReverse(double[] data){
        double[] data2 = data.clone();
        for (int i=0;i<data.length;i++){
            data2[i] = -data[i];
        }
        return data2;
    }
    public static ArrayList getReverse(ArrayList data){
        ArrayList data2 = new ArrayList();
        Object[] data3 =data.toArray();
        for (int i = 0; i < data3.length; i++) {
			data2.add(-Double.parseDouble(data3[i].toString()));
		}
        return data2;
    }
}
