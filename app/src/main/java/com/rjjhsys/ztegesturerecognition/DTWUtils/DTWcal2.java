package com.rjjhsys.ztegesturerecognition.DTWUtils;

import com.rjjhsys.ztegesturerecognition.MyApplication;
import com.rjjhsys.ztegesturerecognition.mathUtil.MinNum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by gongyan on 2017/6/7.
 * 这个类只识别V与O两个类
 */

public class DTWcal2 {
    public static char getDTWselect(double[] gyrX, double[] gyrY, double[] gyrZ) {
        double[] dtwDist = new double[42];
        dtwDist[0] = DtwMatlab.getDtwDistance(MyApplication.V1[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V1[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V1[2], gyrZ);
        dtwDist[1] = DtwMatlab.getDtwDistance(MyApplication.V2[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V2[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V2[2], gyrZ);
        dtwDist[2] = DtwMatlab.getDtwDistance(MyApplication.V3[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V3[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V3[2], gyrZ);
//        for (int i= 0;i<dtwDist[2].)
        dtwDist[3] = DtwMatlab.getDtwDistance(MyApplication.V4[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V4[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V4[2], gyrZ);
        dtwDist[4] = DtwMatlab.getDtwDistance(MyApplication.V5[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V5[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V5[2], gyrZ);
        dtwDist[5] = DtwMatlab.getDtwDistance(MyApplication.V6[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V6[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V6[2], gyrZ);

        dtwDist[6] = DtwMatlab.getDtwDistance(MyApplication.V7[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V7[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V7[2], gyrZ);
        dtwDist[7] = DtwMatlab.getDtwDistance(MyApplication.V8[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V8[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V8[2], gyrZ);
        dtwDist[8] = DtwMatlab.getDtwDistance(MyApplication.V9[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V9[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V9[2], gyrZ);

        dtwDist[9] = DtwMatlab.getDtwDistance(MyApplication.V10[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V10[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V10[2], gyrZ);
        dtwDist[10] = DtwMatlab.getDtwDistance(MyApplication.V11[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V11[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V11[2], gyrZ);
        dtwDist[11] = DtwMatlab.getDtwDistance(MyApplication.V12[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V12[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V12[2], gyrZ);

        dtwDist[12] =DtwMatlab.getDtwDistance(MyApplication.O1[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O1[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O1[2], gyrZ);
        dtwDist[13] =DtwMatlab.getDtwDistance(MyApplication.O2[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O2[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O2[2], gyrZ);
        dtwDist[14] = DtwMatlab.getDtwDistance(MyApplication.O3[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O3[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O3[2], gyrZ);

        dtwDist[15] = DtwMatlab.getDtwDistance(MyApplication.O4[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O4[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O4[2], gyrZ);
        dtwDist[16] = DtwMatlab.getDtwDistance(MyApplication.O5[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O5[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O5[2], gyrZ);
        dtwDist[17] = DtwMatlab.getDtwDistance(MyApplication.O6[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O6[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O6[2], gyrZ);
        dtwDist[18] = DtwMatlab.getDtwDistance(MyApplication.O7[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O7[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O7[2], gyrZ);
        dtwDist[19] = DtwMatlab.getDtwDistance(MyApplication.O8[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O8[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O8[2], gyrZ);
        dtwDist[20] = DtwMatlab.getDtwDistance(MyApplication.O9[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O9[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O9[2], gyrZ);
        dtwDist[21] = DtwMatlab.getDtwDistance(MyApplication.O10[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O10[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O10[2], gyrZ);
        dtwDist[22] = DtwMatlab.getDtwDistance(MyApplication.O11[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O11[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O11[2], gyrZ);
        dtwDist[23] = DtwMatlab.getDtwDistance(MyApplication.O12[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O12[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O12[2], gyrZ);
        dtwDist[24] = DtwMatlab.getDtwDistance(MyApplication.O13[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O13[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O13[2], gyrZ);
        dtwDist[25] = DtwMatlab.getDtwDistance(MyApplication.O14[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O14[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O14[2], gyrZ);
        dtwDist[26] = DtwMatlab.getDtwDistance(MyApplication.O15[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O15[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O15[2], gyrZ);

        dtwDist[27] = DtwMatlab.getDtwDistance(MyApplication.V13[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V13[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V13[2], gyrZ);
        dtwDist[28] = DtwMatlab.getDtwDistance(MyApplication.V14[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V14[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V14[2], gyrZ);
        dtwDist[29] = DtwMatlab.getDtwDistance(MyApplication.V15[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V15[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V15[2], gyrZ);
        dtwDist[30] = DtwMatlab.getDtwDistance(MyApplication.O16[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O16[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O16[2], gyrZ);
        dtwDist[31] = DtwMatlab.getDtwDistance(MyApplication.O17[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O17[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O17[2], gyrZ);
        dtwDist[32] = DtwMatlab.getDtwDistance(MyApplication.O18[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O18[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O18[2], gyrZ);

        dtwDist[33] = DtwMatlab.getDtwDistance(MyApplication.V16[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V16[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V16[2], gyrZ);
        dtwDist[34] = DtwMatlab.getDtwDistance(MyApplication.V17[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V17[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V17[2], gyrZ);
        dtwDist[35] = DtwMatlab.getDtwDistance(MyApplication.V18[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V18[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V18[2], gyrZ);
        dtwDist[36] = DtwMatlab.getDtwDistance(MyApplication.O16[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O16[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O16[2], gyrZ);
        dtwDist[37] = DtwMatlab.getDtwDistance(MyApplication.O17[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O17[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O17[2], gyrZ);
        dtwDist[38] = DtwMatlab.getDtwDistance(MyApplication.O18[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.O18[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.O18[2], gyrZ);

        dtwDist[39] = DtwMatlab.getDtwDistance(MyApplication.V16[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V16[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V16[2], gyrZ);
        dtwDist[40] = DtwMatlab.getDtwDistance(MyApplication.V17[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V17[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V17[2], gyrZ);
        dtwDist[41] = DtwMatlab.getDtwDistance(MyApplication.V18[0], gyrX)
                + DtwMatlab.getDtwDistance(MyApplication.V18[1], gyrY)
                + DtwMatlab.getDtwDistance(MyApplication.V18[2], gyrZ);
        HashMap<Double, Character> map = new HashMap();
        map.put(dtwDist[0], 'V');
        map.put(dtwDist[1], 'V');
        map.put(dtwDist[2], 'V');
        map.put(dtwDist[3], 'V');
        map.put(dtwDist[4], 'V');
        map.put(dtwDist[5], 'V');
        map.put(dtwDist[6], 'V');
        map.put(dtwDist[7], 'V');
        map.put(dtwDist[8], 'V');
        map.put(dtwDist[9], 'V');
        map.put(dtwDist[10], 'V');
        map.put(dtwDist[11], 'V');
        map.put(dtwDist[12], 'O');
        map.put(dtwDist[13], 'O');
        map.put(dtwDist[14], 'O');
        map.put(dtwDist[15], 'O');
        map.put(dtwDist[16], 'O');
        map.put(dtwDist[17], 'O');
        map.put(dtwDist[18], 'O');
        map.put(dtwDist[19], 'O');
        map.put(dtwDist[20], 'O');
        map.put(dtwDist[21], 'O');
        map.put(dtwDist[22], 'O');
        map.put(dtwDist[23], 'O');
        map.put(dtwDist[24], 'O');
        map.put(dtwDist[25], 'O');
        map.put(dtwDist[26], 'O');
        map.put(dtwDist[27], 'V');
        map.put(dtwDist[28], 'V');
        map.put(dtwDist[29], 'V');
        map.put(dtwDist[30], 'O');
        map.put(dtwDist[31], 'O');
        map.put(dtwDist[32], 'O');
        map.put(dtwDist[33], 'V');
        map.put(dtwDist[34], 'V');
        map.put(dtwDist[35], 'V');
        map.put(dtwDist[36], 'V');
        map.put(dtwDist[37], 'V');
        map.put(dtwDist[38], 'V');
        map.put(dtwDist[39], 'V');
        map.put(dtwDist[40], 'V');
        map.put(dtwDist[41], 'V');

            //投票选择
        double[] mutilMin = MinNum.getMultiMinNum(dtwDist, 11);
        char re = 'q';
        double throld = 100;
        ///判断是否属于判断范围内
        Set<Double> tt = map.keySet();
        System.out.println(tt);
        System.out.println("getMinNum(dtwDist)---"+MinNum.getMinNum(dtwDist));
        if(MinNum.getMinNum(dtwDist)>throld){
            System.out.println("最小距离是"+MinNum.getMinNum(dtwDist));
            return re;
        }else {
            re = map.get(MinNum.getMinNum(dtwDist));
        }
        //返回的是最小的五个值，在map中是key


        HashMap<Character, Integer> map2 = new HashMap();//保存label和出现的次数
        HashMap<Character, Double> mapDist = new HashMap<>(); //保存label和对应的距离值
        for (int i = 0; i < 11; i++) {

            if (!map2.containsKey(map.get(mutilMin[i]))) {
                map2.put(map.get(mutilMin[i]), 1);
                mapDist.put(map.get(mutilMin[i]), mutilMin[i]);
                System.out.println("136----添加了"+map.get(mutilMin[i]));
            } else {
                System.out.println("138----重复了"+map.get(mutilMin[i]));
                map2.put(map.get(mutilMin[i]), map2.get(map.get(mutilMin[i])) + 1);
                mapDist.put(map.get(mutilMin[i]), mapDist.get(map.get(mutilMin[i])) + mutilMin[i]);
            }
        }
//排序，key与value分别放入数组，然后同时排序

        Iterator iterator = map2.keySet().iterator();
        Iterator iterator1 = map2.values().iterator();
        int[] times = new int[map2.values().size()];
        char[] label = new char[map2.keySet().size()];
        int numT = 0;
        while (iterator.hasNext() && iterator1.hasNext()) {
            times[numT] = (int) iterator1.next();
            label[numT] = (Character) iterator.next();
            numT++;
//            System.out.println("154-"+times[numT]+"*****"+label[numT]);
        }
        for (int i=0;i<times.length;i++){
            System.out.println("155-"+times[i]+"*****"+label[i]);
        }
        for (int i = 0; i < times.length - 1; i++) { // 最多做n-1趟排序
            for (int j = 0; j < times.length - 1; j++) { // 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
                if (times[j] < times[j + 1]) { // 把小的值交换到后面
                    int temp = times[j];
                    char temp2 = label[j];
                    times[j] = times[j + 1];
                    label[j] = label[j + 1];
                    times[j + 1] = temp;
                    label[j + 1] = temp2;
                }
            }

        }
for (int i=0;i<times.length;i++){
    System.out.println(times[i]+"*****"+label[i]);
}

if (label[0]>7){
    System.out.println("171DTWcal+结果" + label[0] + "共有" + times[0]);
//    re = label[0];
}else if (label[1]>7){
    System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//    re = label[1];
}
//        if (map2.size() <=2) {//3+2  4+1 5+0
//            re = label[0];
//            System.out.println("171DTWcal+结果" + label[0] + "共有" + times[0]);
//            System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//
//        } else if (3 == map2.size()) {//2+2+1  3+1+1
//            //2+2+1
//            if (3 == times[0]) {//3+1+1
//                re = label[0];
//                System.out.println("178DTWcal+结果" + label[0] + "共有" + times[0]);
//                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//            } else if (2 == times[0]) {//2+2+1,哪个距离小取哪个
//                if (mapDist.get(label[0]) < mapDist.get(label[0])) {
//                    re = label[0];
//                    System.out.println("183DTWcal+结果" + label[0] + "共有" + times[0]);
//                    System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//
//                } else {
//                    re = label[0];
//                    System.out.println("188DTWcal+结果" + label[1] + "共有" + times[1]);
//                    System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[0]);
//
//                }
//            }
//        }else if (4 == map2.size()){
//            if (2 == times[0]){
//                re = label[0];
//                System.out.println("196DTWcal+结果" + label[0] + "共有" + times[0]);
//                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//
//            }else{
//                re = label[0];
//                System.out.println("201DTWcal+结果" + label[0] + "共有" + times[0]);
//                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//
//            }
//        }


//        double minValue = MinNum.getMinNum(dtwDist);
//        System.out.println("dtwCal--" + minValue);
        return re;

    }
//    public static char getSDTWselect(double[] gyrX, double[] gyrY, double[] gyrZ) {
//        double[] dtwDist = new double[21];
//        dtwDist[0] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c1[0]), MyApplication.c1[0].length,
//                gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c1[1]), MyApplication.c1[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c1[2]), MyApplication.c1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[1] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c2[0]), MyApplication.c2[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c2[1]), MyApplication.c2[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c2[2]), MyApplication.c2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[2] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c3[0]), MyApplication.c3[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c3[1]), MyApplication.c3[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c3[2]), MyApplication.c3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//
//        dtwDist[3] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o1[0]), MyApplication.o1[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o1[1]), MyApplication.o1[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o1[2]), MyApplication.o1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[4] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o2[0]), MyApplication.o2[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o2[1]), MyApplication.o2[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o2[2]), MyApplication.o2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[5] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o3[0]), MyApplication.o3[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o3[1]), MyApplication.o3[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o3[2]), MyApplication.o3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//
//        dtwDist[6] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e1[0]), MyApplication.e1[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e1[1]), MyApplication.e1[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e1[2]), MyApplication.e1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[7] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e2[0]), MyApplication.e2[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e2[1]), MyApplication.e2[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e2[2]), MyApplication.e2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[8] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e3[0]), MyApplication.e3[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e3[1]), MyApplication.e3[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e3[2]), MyApplication.e3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//
//        dtwDist[9] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v1[0]), MyApplication.v1[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v1[1]), MyApplication.v1[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v1[2]), MyApplication.v1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[10] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v2[0]), MyApplication.v2[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v2[1]), MyApplication.v2[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v2[2]), MyApplication.v2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[11] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v3[0]), MyApplication.v3[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v3[1]), MyApplication.v3[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v3[2]), MyApplication.v3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//
//        dtwDist[12] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u1[0]), MyApplication.u1[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u1[1]), MyApplication.u1[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u1[2]), MyApplication.u1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[13] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u2[0]), MyApplication.u2[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u2[1]), MyApplication.u2[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u2[2]), MyApplication.u2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[14] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u3[0]), MyApplication.u3[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u3[1]), MyApplication.u3[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u3[2]), MyApplication.u3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//
//        dtwDist[15] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w1[0]), MyApplication.w1[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w1[1]), MyApplication.w1[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w1[2]), MyApplication.w1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[16] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w2[0]), MyApplication.w2[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w2[1]), MyApplication.w2[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w2[2]), MyApplication.w2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[17] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w3[0]), MyApplication.w3[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w3[1]), MyApplication.w3[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w3[2]), MyApplication.w3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//
//        dtwDist[18] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y1[0]), MyApplication.y1[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y1[1]), MyApplication.y1[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y1[2]), MyApplication.y1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[19] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y2[0]), MyApplication.y2[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y2[1]), MyApplication.y2[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y2[2]), MyApplication.y2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        dtwDist[20] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y3[0]), MyApplication.y3[0].length, gyrX, gyrX.length, gyrX.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y3[1]), MyApplication.y3[1].length, gyrY, gyrY.length, gyrY.length / 10)
//                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y3[2]), MyApplication.y3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
//        HashMap<Double, Character> map = new HashMap();
//        map.put(dtwDist[0], 'c');
//        map.put(dtwDist[1], 'c');
//        map.put(dtwDist[2], 'c');
//        map.put(dtwDist[3], 'o');
//        map.put(dtwDist[4], 'o');
//        map.put(dtwDist[5], 'o');
//        map.put(dtwDist[6], 'e');
//        map.put(dtwDist[7], 'e');
//        map.put(dtwDist[8], 'e');
//        map.put(dtwDist[9], 'v');
//        map.put(dtwDist[10], 'v');
//        map.put(dtwDist[11], 'v');
//        map.put(dtwDist[12], 'u');
//        map.put(dtwDist[13], 'u');
//        map.put(dtwDist[14], 'u');
//        map.put(dtwDist[15], 'w');
//        map.put(dtwDist[16], 'w');
//        map.put(dtwDist[17], 'w');
//        map.put(dtwDist[18], 'y');
//        map.put(dtwDist[19], 'y');
//        map.put(dtwDist[20], 'y');
//
//
//        //投票选择
//        double[] mutilMin = MinNum.getMultiMinNum(dtwDist, 5);
//        char re = 'q';
//        double throld = 1300;
//        ///判断是否属于判断范围内
//        Set<Double> tt = map.keySet();
//        System.out.println(tt);
//        System.out.println(MinNum.getMinNum(dtwDist));
//        if(MinNum.getMinNum(dtwDist)>throld){
//            System.out.println("最小距离是"+MinNum.getMinNum(dtwDist));
//            return re;
//        }
//        //返回的是最小的五个值，在map中是key
//
//
//        HashMap<Character, Integer> map2 = new HashMap();//保存label和出现的次数
//        HashMap<Character, Double> mapDist = new HashMap<>(); //保存label和对应的距离值
//        for (int i = 0; i < 5; i++) {
//
//            if (!map2.containsKey(map.get(mutilMin[i]))) {
//                map2.put(map.get(mutilMin[i]), 1);
//                mapDist.put(map.get(mutilMin[i]), mutilMin[i]);
//                System.out.println("136----添加了"+map.get(mutilMin[i]));
//            } else {
//                System.out.println("138----重复了"+map.get(mutilMin[i]));
//                map2.put(map.get(mutilMin[i]), map2.get(map.get(mutilMin[i])) + 1);
//                mapDist.put(map.get(mutilMin[i]), mapDist.get(map.get(mutilMin[i])) + mutilMin[i]);
//            }
//        }
////排序，key与value分别放入数组，然后同时排序
//
//        Iterator iterator = map2.keySet().iterator();
//        Iterator iterator1 = map2.values().iterator();
//        int[] times = new int[map2.values().size()];
//        char[] label = new char[map2.keySet().size()];
//        int numT = 0;
//        while (iterator.hasNext() && iterator1.hasNext()) {
//            times[numT] = (int) iterator1.next();
//            label[numT] = (Character) iterator.next();
//            numT++;
////            System.out.println("154-"+times[numT]+"*****"+label[numT]);
//        }
//
//        for (int i = 0; i < times.length - 1; i++) { // 最多做n-1趟排序
//            for (int j = 0; j < times.length - 1; j++) { // 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
//                if (times[j] < times[j + 1]) { // 把小的值交换到后面
//                    int temp = times[j];
//                    char temp2 = label[j];
//                    times[j] = times[j + 1];
//                    label[j] = label[j + 1];
//                    times[j + 1] = temp;
//                    label[j + 1] = temp2;
//                }
//            }
//
//        }
//        for (int i=0;i<times.length;i++){
//            System.out.println(times[i]+"*****"+label[i]);
//        }
//        if (map2.size() <=2) {//3+2  4+1 5+0
//            re = label[0];
//            System.out.println("171DTWcal+结果" + label[0] + "共有" + times[0]);
//            System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//
//        } else if (3 == map2.size()) {//2+2+1  3+1+1
//            //2+2+1
//            if (3 == times[0]) {//3+1+1
//                re = label[0];
//                System.out.println("178DTWcal+结果" + label[0] + "共有" + times[0]);
//                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//            } else if (2 == times[0]) {//2+2+1,哪个距离小取哪个
//                if (mapDist.get(label[0]) < mapDist.get(label[0])) {
//                    re = label[0];
//                    System.out.println("183DTWcal+结果" + label[0] + "共有" + times[0]);
//                    System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//
//                } else {
//                    re = label[0];
//                    System.out.println("188DTWcal+结果" + label[1] + "共有" + times[1]);
//                    System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[0]);
//
//                }
//            }
//        }else if (4 == map2.size()){
//            if (2 == times[0]){
//                re = label[0];
//                System.out.println("196DTWcal+结果" + label[0] + "共有" + times[0]);
//                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//
//            }else{
//                re = label[0];
//                System.out.println("201DTWcal+结果" + label[0] + "共有" + times[0]);
//                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
//
//            }
//        }
//
//
////        double minValue = MinNum.getMinNum(dtwDist);
////        System.out.println("dtwCal--" + minValue);
//        return re;
//
//    }
}
