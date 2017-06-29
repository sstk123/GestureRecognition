package com.rjjhsys.ztegesturerecognition.DTWUtils;

import com.rjjhsys.ztegesturerecognition.MyApplication;
import com.rjjhsys.ztegesturerecognition.OtherUtils.DataBox;
import com.rjjhsys.ztegesturerecognition.mathUtil.MinNum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by gongyan on 2017/6/7.
 */

public class DTWcal {
    public static char getDTWselect(double[] gyrX, double[] gyrY, double[] gyrZ) {
        double[] dtwDist = new double[21];
        System.out.println("dtwcal" + gyrX.length);
        dtwDist[0] = DTW.getDtwDistance(MyApplication.c1[0], MyApplication.c1[0].length,
                gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.c1[1], MyApplication.c1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.c1[2], MyApplication.c1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[1] = DTW.getDtwDistance(MyApplication.c2[0], MyApplication.c2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.c2[1], MyApplication.c2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.c2[2], MyApplication.c2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[2] = DTW.getDtwDistance(MyApplication.c3[0], MyApplication.c3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.c3[1], MyApplication.c3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.c3[2], MyApplication.c3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[3] = DTW.getDtwDistance(MyApplication.o1[0], MyApplication.o1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.o1[1], MyApplication.o1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.o1[2], MyApplication.o1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[4] = DTW.getDtwDistance(MyApplication.o2[0], MyApplication.o2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.o2[1], MyApplication.o2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.o2[2], MyApplication.o2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[5] = DTW.getDtwDistance(MyApplication.o3[0], MyApplication.o3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.o3[1], MyApplication.o3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.o3[2], MyApplication.o3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[6] = DTW.getDtwDistance(MyApplication.e1[0], MyApplication.e1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.e1[1], MyApplication.e1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.e1[2], MyApplication.e1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[7] = DTW.getDtwDistance(MyApplication.e2[0], MyApplication.e2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.e2[1], MyApplication.e2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.e2[2], MyApplication.e2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[8] = DTW.getDtwDistance(MyApplication.e3[0], MyApplication.e3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.e3[1], MyApplication.e3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.e3[2], MyApplication.e3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[9] = DTW.getDtwDistance(MyApplication.v1[0], MyApplication.v1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.v1[1], MyApplication.v1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.v1[2], MyApplication.v1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[10] = DTW.getDtwDistance(MyApplication.v2[0], MyApplication.v2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.v2[1], MyApplication.v2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.v2[2], MyApplication.v2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[11] = DTW.getDtwDistance(MyApplication.v3[0], MyApplication.v3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.v3[1], MyApplication.v3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.v3[2], MyApplication.v3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[12] = DTW.getDtwDistance(MyApplication.u1[0], MyApplication.u1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.u1[1], MyApplication.u1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.u1[2], MyApplication.u1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[13] = DTW.getDtwDistance(MyApplication.u2[0], MyApplication.u2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.u2[1], MyApplication.u2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.u2[2], MyApplication.u2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[14] = DTW.getDtwDistance(MyApplication.u3[0], MyApplication.u3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.u3[1], MyApplication.u3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.u3[2], MyApplication.u3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[15] = DTW.getDtwDistance(MyApplication.w1[0], MyApplication.w1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.w1[1], MyApplication.w1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.w1[2], MyApplication.w1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[16] = DTW.getDtwDistance(MyApplication.w2[0], MyApplication.w2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.w2[1], MyApplication.w2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.w2[2], MyApplication.w2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[17] = DTW.getDtwDistance(MyApplication.w3[0], MyApplication.w3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.w3[1], MyApplication.w3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.w3[2], MyApplication.w3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[18] = DTW.getDtwDistance(MyApplication.y1[0], MyApplication.y1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.y1[1], MyApplication.y1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.y1[2], MyApplication.y1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[19] = DTW.getDtwDistance(MyApplication.y2[0], MyApplication.y2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.y2[1], MyApplication.y2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.y2[2], MyApplication.y2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[20] = DTW.getDtwDistance(MyApplication.y3[0], MyApplication.y3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(MyApplication.y3[1], MyApplication.y3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(MyApplication.y3[2], MyApplication.y3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        HashMap<Double, Character> map = new HashMap();
        map.put(dtwDist[0], 'c');
        map.put(dtwDist[1], 'c');
        map.put(dtwDist[2], 'c');
        map.put(dtwDist[3], 'o');
        map.put(dtwDist[4], 'o');
        map.put(dtwDist[5], 'o');
        map.put(dtwDist[6], 'e');
        map.put(dtwDist[7], 'e');
        map.put(dtwDist[8], 'e');
        map.put(dtwDist[9], 'v');
        map.put(dtwDist[10], 'v');
        map.put(dtwDist[11], 'v');
        map.put(dtwDist[12], 'u');
        map.put(dtwDist[13], 'u');
        map.put(dtwDist[14], 'u');
        map.put(dtwDist[15], 'w');
        map.put(dtwDist[16], 'w');
        map.put(dtwDist[17], 'w');
        map.put(dtwDist[18], 'y');
        map.put(dtwDist[19], 'y');
        map.put(dtwDist[20], 'y');


            //投票选择
        double[] mutilMin = MinNum.getMultiMinNum(dtwDist, 5);
        char re = 'q';
        double throld = 1300;
        ///判断是否属于判断范围内
        Set<Double> tt = map.keySet();
        System.out.println(tt);
        System.out.println(MinNum.getMinNum(dtwDist));
        if(MinNum.getMinNum(dtwDist)>throld){
            System.out.println("最小距离是"+MinNum.getMinNum(dtwDist));
            return re;
        }
        //返回的是最小的五个值，在map中是key


        HashMap<Character, Integer> map2 = new HashMap();//保存label和出现的次数
        HashMap<Character, Double> mapDist = new HashMap<>(); //保存label和对应的距离值
        for (int i = 0; i < 5; i++) {

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
        if (map2.size() <=2) {//3+2  4+1 5+0
            re = label[0];
            System.out.println("171DTWcal+结果" + label[0] + "共有" + times[0]);
            System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);

        } else if (3 == map2.size()) {//2+2+1  3+1+1
            //2+2+1
            if (3 == times[0]) {//3+1+1
                re = label[0];
                System.out.println("178DTWcal+结果" + label[0] + "共有" + times[0]);
                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
            } else if (2 == times[0]) {//2+2+1,哪个距离小取哪个
                if (mapDist.get(label[0]) < mapDist.get(label[0])) {
                    re = label[0];
                    System.out.println("183DTWcal+结果" + label[0] + "共有" + times[0]);
                    System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);

                } else {
                    re = label[0];
                    System.out.println("188DTWcal+结果" + label[1] + "共有" + times[1]);
                    System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[0]);

                }
            }
        }else if (4 == map2.size()){
            if (2 == times[0]){
                re = label[0];
                System.out.println("196DTWcal+结果" + label[0] + "共有" + times[0]);
                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);

            }else{
                re = label[0];
                System.out.println("201DTWcal+结果" + label[0] + "共有" + times[0]);
                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);

            }
        }


//        double minValue = MinNum.getMinNum(dtwDist);
//        System.out.println("dtwCal--" + minValue);
        return re;

    }
    public static char getSDTWselect(double[] gyrX, double[] gyrY, double[] gyrZ) {
        double[] dtwDist = new double[21];
        dtwDist[0] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c1[0]), MyApplication.c1[0].length,
                gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c1[1]), MyApplication.c1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c1[2]), MyApplication.c1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[1] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c2[0]), MyApplication.c2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c2[1]), MyApplication.c2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c2[2]), MyApplication.c2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[2] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c3[0]), MyApplication.c3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c3[1]), MyApplication.c3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.c3[2]), MyApplication.c3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[3] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o1[0]), MyApplication.o1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o1[1]), MyApplication.o1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o1[2]), MyApplication.o1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[4] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o2[0]), MyApplication.o2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o2[1]), MyApplication.o2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o2[2]), MyApplication.o2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[5] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o3[0]), MyApplication.o3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o3[1]), MyApplication.o3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.o3[2]), MyApplication.o3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[6] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e1[0]), MyApplication.e1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e1[1]), MyApplication.e1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e1[2]), MyApplication.e1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[7] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e2[0]), MyApplication.e2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e2[1]), MyApplication.e2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e2[2]), MyApplication.e2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[8] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e3[0]), MyApplication.e3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e3[1]), MyApplication.e3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.e3[2]), MyApplication.e3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[9] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v1[0]), MyApplication.v1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v1[1]), MyApplication.v1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v1[2]), MyApplication.v1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[10] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v2[0]), MyApplication.v2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v2[1]), MyApplication.v2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v2[2]), MyApplication.v2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[11] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v3[0]), MyApplication.v3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v3[1]), MyApplication.v3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.v3[2]), MyApplication.v3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[12] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u1[0]), MyApplication.u1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u1[1]), MyApplication.u1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u1[2]), MyApplication.u1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[13] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u2[0]), MyApplication.u2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u2[1]), MyApplication.u2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u2[2]), MyApplication.u2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[14] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u3[0]), MyApplication.u3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u3[1]), MyApplication.u3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.u3[2]), MyApplication.u3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[15] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w1[0]), MyApplication.w1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w1[1]), MyApplication.w1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w1[2]), MyApplication.w1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[16] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w2[0]), MyApplication.w2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w2[1]), MyApplication.w2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w2[2]), MyApplication.w2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[17] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w3[0]), MyApplication.w3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w3[1]), MyApplication.w3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.w3[2]), MyApplication.w3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);

        dtwDist[18] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y1[0]), MyApplication.y1[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y1[1]), MyApplication.y1[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y1[2]), MyApplication.y1[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[19] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y2[0]), MyApplication.y2[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y2[1]), MyApplication.y2[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y2[2]), MyApplication.y2[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        dtwDist[20] = DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y3[0]), MyApplication.y3[0].length, gyrX, gyrX.length, gyrX.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y3[1]), MyApplication.y3[1].length, gyrY, gyrY.length, gyrY.length / 10)
                + DTW.getDtwDistance(DataBox.DataBoxHandle(MyApplication.y3[2]), MyApplication.y3[2].length, gyrZ, gyrZ.length, gyrZ.length / 10);
        HashMap<Double, Character> map = new HashMap();
        map.put(dtwDist[0], 'c');
        map.put(dtwDist[1], 'c');
        map.put(dtwDist[2], 'c');
        map.put(dtwDist[3], 'o');
        map.put(dtwDist[4], 'o');
        map.put(dtwDist[5], 'o');
        map.put(dtwDist[6], 'e');
        map.put(dtwDist[7], 'e');
        map.put(dtwDist[8], 'e');
        map.put(dtwDist[9], 'v');
        map.put(dtwDist[10], 'v');
        map.put(dtwDist[11], 'v');
        map.put(dtwDist[12], 'u');
        map.put(dtwDist[13], 'u');
        map.put(dtwDist[14], 'u');
        map.put(dtwDist[15], 'w');
        map.put(dtwDist[16], 'w');
        map.put(dtwDist[17], 'w');
        map.put(dtwDist[18], 'y');
        map.put(dtwDist[19], 'y');
        map.put(dtwDist[20], 'y');


        //投票选择
        double[] mutilMin = MinNum.getMultiMinNum(dtwDist, 5);
        char re = 'q';
        double throld = 1300;
        ///判断是否属于判断范围内
        Set<Double> tt = map.keySet();
        System.out.println(tt);
        System.out.println(MinNum.getMinNum(dtwDist));
        if(MinNum.getMinNum(dtwDist)>throld){
            System.out.println("最小距离是"+MinNum.getMinNum(dtwDist));
            return re;
        }
        //返回的是最小的五个值，在map中是key


        HashMap<Character, Integer> map2 = new HashMap();//保存label和出现的次数
        HashMap<Character, Double> mapDist = new HashMap<>(); //保存label和对应的距离值
        for (int i = 0; i < 5; i++) {

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
        if (map2.size() <=2) {//3+2  4+1 5+0
            re = label[0];
            System.out.println("171DTWcal+结果" + label[0] + "共有" + times[0]);
            System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);

        } else if (3 == map2.size()) {//2+2+1  3+1+1
            //2+2+1
            if (3 == times[0]) {//3+1+1
                re = label[0];
                System.out.println("178DTWcal+结果" + label[0] + "共有" + times[0]);
                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);
            } else if (2 == times[0]) {//2+2+1,哪个距离小取哪个
                if (mapDist.get(label[0]) < mapDist.get(label[0])) {
                    re = label[0];
                    System.out.println("183DTWcal+结果" + label[0] + "共有" + times[0]);
                    System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);

                } else {
                    re = label[0];
                    System.out.println("188DTWcal+结果" + label[1] + "共有" + times[1]);
                    System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[0]);

                }
            }
        }else if (4 == map2.size()){
            if (2 == times[0]){
                re = label[0];
                System.out.println("196DTWcal+结果" + label[0] + "共有" + times[0]);
                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);

            }else{
                re = label[0];
                System.out.println("201DTWcal+结果" + label[0] + "共有" + times[0]);
                System.out.println("DTWcal+待选结果" + label[1] + "共有" + times[1]);

            }
        }


//        double minValue = MinNum.getMinNum(dtwDist);
//        System.out.println("dtwCal--" + minValue);
        return re;

    }
}
