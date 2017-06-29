package com.rjjhsys.ztegesturerecognition.OtherUtils;

import android.util.Log;

/**
 * Created by Administrator on 2016/4/5.
 * 采用线性函数归一化，即max-min标准化
 */
public class Normalization {
    public static double[] NormalizationMaxMin(double a[]) {

        double b[] = new double[1000];
        b = (double[]) a.clone();
        for (int q = 0; q < b.length && b[q] != 0; q++) {
            Log.d("mysNormalization22222", String.valueOf(b[q]));
        }
        java.util.Arrays.sort(a);
        double minNum, maxNum;
        int i = 0;

        ///************先获取数组中最大与最小的值
        //最大值通过排序后直接获得，由于数组中有非数据的0存在，必须把0先排除掉
        maxNum = a[a.length - 1];
        while (a[i] == 0) {
            i++;
        }
        minNum = a[i];
        for (int j = 0; j < b.length && b[j] != 0; j++) {
            if (b[j] == minNum) {
                b[j] = 0.01;
            } else {
                b[j] = ((b[j] - minNum) / (maxNum - minNum));
            }
        }

        for (int q = 0; q < b.length && b[q] != 0; q++) {
        }
        return b;
    }

    public static double[][] NormalizationMaxMin(double a[][]) {

        double[] minNum = new double[3];
        minNum[0] = a[0][0];
        minNum[1] = a[0][1];
        minNum[2] = a[0][2];
        double[] maxNum = new double[3];
        maxNum[0] = a[0][0];
        maxNum[1] = a[0][1];
        maxNum[2] = a[0][2];
        //获取数组中的两个最值
        for (int k = 0; k < 3; k++) {
            for (int i = 1; i < a.length; i++) {
                if (a[i][k] < minNum[k]) {
                    minNum[k] = a[i][k];
                }
                if (a[i][0] > maxNum[k]) {
                    maxNum[k] = a[i][k];
                }
                if (a[i][k]== 0 ){

                    break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
        }
        //进行归一化处理
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j][i] == minNum[i]) {
                    a[j][i] = 0.01;
                } else if(a[j][i]==0)
                {
                    break;
                }else {
                    a[j][i] = ((a[j][i] - minNum[i]) / (maxNum[i] - minNum[i]));
                }
            }

        }
        return a;
    }

    public static double[][] NormalizationMaxMinNull(double a[][]) {
        Log.v("mysNormalization", "当前jiazhung在进行归一化处理。。。");
        return a;
    }
    //********0均值归一化

    public static  double[] NormalizationZScore (double a[]){
double mean,StandardDeviation,sum=0;
        int j,i;
        Log.d("mysNormalization", "正在进行归一化处理。。。");
        for ( j=0;j<a.length&&a[j]!=0;j++){
           sum+=a[j];
        }
        mean=(sum/(j-1));
        sum=0;
        for (  i=0;i<a.length&&a[i]!=0;i++){
            sum+=(a[i]-mean)*(a[i]-mean);
        }
        StandardDeviation= Math.sqrt(sum/(i-1));
        for ( j=0;j<a.length&&a[j]!=0;j++){
            if(a[j]==mean){
                a[j]=0.01;
            }else {
            a[j]=((a[j]-mean)/StandardDeviation);
        }}

        return a;
    }
}
