package com.rjjhsys.ztegesturerecognition;

import com.rjjhsys.ztegesturerecognition.mathUtil.*;

import java.util.ArrayList;

/**
 * Created by gongyan on 2017/6/3.
 */

public class FeatureExtract {
    public static double[] getFeature(ArrayList accX,ArrayList accY,ArrayList accZ,ArrayList gyrX,ArrayList gyrY,ArrayList gyrZ){

        double[] feature = new double[48];
        //最大值
        double maxAccX = MaxNum.getMaxNum(accX);
        double maxAccY = MaxNum.getMaxNum(accY);
        double maxAccZ = MaxNum.getMaxNum(accZ);
        double maxGyrX = MaxNum.getMaxNum(gyrX);
        double maxGyrY = MaxNum.getMaxNum(gyrY);
        double maxGyrZ = MaxNum.getMaxNum(gyrZ);
        //最小值
        double minAccX = MinNum.getMinNum(accX);
        double minAccY = MinNum.getMinNum(accY);
        double minAccZ = MinNum.getMinNum(accZ);
        double minGyrX = MinNum.getMinNum(gyrX);
        double minGyrY = MinNum.getMinNum(gyrY);
        double minGyrZ = MinNum.getMinNum(gyrZ);
        //平均值
        double aveAccX = Average.getAverage(accX);
        double aveAccY = Average.getAverage(accY);
        double aveAccZ = Average.getAverage(accZ);
        double aveGyrX = Average.getAverage(gyrX);
        double aveGyrY = Average.getAverage(gyrY);
        double aveGyrZ = Average.getAverage(gyrZ);
        //能量
        double energyAccX = Energy.getEnergy(accX);
        double energyAccY = Energy.getEnergy(accY);
        double energyAccZ = Energy.getEnergy(accZ);
        double energyGyrX = Energy.getEnergy(gyrX);
        double energyGyrY = Energy.getEnergy(gyrY);
        double energyGyrZ = Energy.getEnergy(gyrZ);
        //波峰数
        double peakAccX = PeaksDetect.getPeakNum(accX,0.7,15);
        double peakAccY = PeaksDetect.getPeakNum(accY,0.7,15);
        double peakAccZ = PeaksDetect.getPeakNum(accZ,0.7,15);
        double peakGyrX = PeaksDetect.getPeakNum(gyrX,0.7,15);
        double peakGyrY = PeaksDetect.getPeakNum(gyrY,0.7,15);
        double peakGyrZ = PeaksDetect.getPeakNum(gyrZ,0.7,15);
        //均方根
        double rmsAccX = RMS.getRMS(accX);
        double rmsAccY = RMS.getRMS(accY);
        double rmsAccZ = RMS.getRMS(accZ);
        double rmsGyrX = RMS.getRMS(gyrX);
        double rmsGyrY = RMS.getRMS(gyrY);
        double rmsGyrZ = RMS.getRMS(gyrZ);
        //标准差
        double stdAccX = StandardDeviation.getStandarDeviation(accX);
        double stdAccY = StandardDeviation.getStandarDeviation(accY);
        double stdAccZ = StandardDeviation.getStandarDeviation(accZ);
        double stdGyrX = StandardDeviation.getStandarDeviation(gyrX);
        double stdGyrY = StandardDeviation.getStandarDeviation(gyrY);
        double stdGyrZ = StandardDeviation.getStandarDeviation(gyrZ);
        //方差
        double varAccX = Variance.getVariance(accX);
        double varAccY = Variance.getVariance(accY);
        double varAccZ = Variance.getVariance(accZ);
        double varGyrX = Variance.getVariance(gyrX);
        double varGyrY = Variance.getVariance(gyrY);
        double varGyrZ = Variance.getVariance(gyrZ);
        //波谷数
        double valleyAccX = PeaksDetect.getPeakNum(ReverseData.getReverse(accX),0.7,15);
        double valleyAccY = PeaksDetect.getPeakNum(ReverseData.getReverse(accY),0.7,15);
        double valleyAccZ = PeaksDetect.getPeakNum(ReverseData.getReverse(accZ),0.7,15);
        double valleyGyrX = PeaksDetect.getPeakNum(ReverseData.getReverse(gyrX),0.7,15);
        double valleyGyrY = PeaksDetect.getPeakNum(ReverseData.getReverse(gyrY),0.7,15);
        double valleyGyrZ = PeaksDetect.getPeakNum(ReverseData.getReverse(gyrZ),0.7,15);

        feature[0] = maxAccX;
        feature[1] = maxAccY;
        feature[2] = maxAccZ;
        feature[3] = maxGyrX;
        feature[4] = maxGyrY;
        feature[5] = maxGyrZ;

        feature[6] = minAccX;
        feature[7] = minAccY;
        feature[8] = minAccZ;
        feature[9] = minGyrX;
        feature[10] = minGyrY;
        feature[11] = minGyrZ;

        feature[12] = valleyAccX;
        feature[13] = valleyAccY;
        feature[14] = valleyAccZ;
        feature[15] = valleyGyrX;
        feature[16] = valleyGyrY;
        feature[17] = valleyGyrZ;

        feature[18] = energyAccX;
        feature[19] = energyAccY;
        feature[20] = energyAccZ;
        feature[21] = energyGyrX;
        feature[22] = energyGyrY;
        feature[23] = energyGyrZ;

        feature[24] = peakAccX;
        feature[25] = peakAccY;
        feature[26] = peakAccZ;
        feature[27] = peakGyrX;
        feature[28] = peakGyrY;
        feature[29] = peakGyrZ;

        feature[30] = rmsAccX;
        feature[31] = rmsAccY;
        feature[32] = rmsAccZ;
        feature[33] = rmsGyrX;
        feature[34] = rmsGyrY;
        feature[35] = rmsGyrZ;

        feature[36] = stdAccX;
        feature[37] = stdAccY;
        feature[38] = stdAccZ;
        feature[39] = stdGyrX;
        feature[40] = stdGyrY;
        feature[41] = stdGyrZ;

        feature[42] = varAccX;
        feature[43] = varAccY;
        feature[44] = varAccZ;
        feature[45] = varGyrX;
        feature[46] = varGyrY;
        feature[47] = varGyrZ;

        return feature;
    }
}
