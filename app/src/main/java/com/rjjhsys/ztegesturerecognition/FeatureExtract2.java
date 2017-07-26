package com.rjjhsys.ztegesturerecognition;

import com.rjjhsys.ztegesturerecognition.FFTUtils.Complex;
import com.rjjhsys.ztegesturerecognition.FFTUtils.Dft;
import com.rjjhsys.ztegesturerecognition.OtherUtils.ListToArray;
import com.rjjhsys.ztegesturerecognition.mathUtil.Average;
import com.rjjhsys.ztegesturerecognition.mathUtil.Energy;
import com.rjjhsys.ztegesturerecognition.mathUtil.Ientropy;
import com.rjjhsys.ztegesturerecognition.mathUtil.PearsonsCorrelation;
import com.rjjhsys.ztegesturerecognition.mathUtil.StandardDeviation;

import java.util.ArrayList;



/**
 * Created by gongyan on 2017/6/3.
 */

public class FeatureExtract2 {
    public static double[] getFeature(ArrayList accX,ArrayList accY,ArrayList accZ,ArrayList gyrX,ArrayList gyrY,ArrayList gyrZ){
        System.out.println("特征提取的数据如下：");
        System.out.println(accX);
        System.out.println(accY);
        System.out.println(accZ);
        System.out.println(gyrX);
        System.out.println(gyrY);
        System.out.println(gyrZ);
        double[] feature = new double[210];
        int segNum = 9;//9ge鐐� 8娈�  7涓猣ragment
        int[] localGyro = new int[segNum];
        int[] localAcc = new int[segNum];
        localGyro[0] = 0;
        localAcc [0] = 0;
        //寰楀埌姣忎竴涓柇鐐圭殑浣嶇疆
        double temp0 = gyrX.size();
        double temp1 = accX.size();

        System.out.println(temp0+"  "+temp1);
        for (int i=1;i<segNum;i++) {

            localAcc[i] = (int) ((temp1-1) / (segNum-1)* i) ;
            localGyro[i] = (int) ((temp0-1) / (segNum-1) * i) ;

        }
        System.out.println("acc位置：");
        for (int i=0;i<localAcc.length;i++){

            System.out.print(localAcc[i]+"  ");
        }
        System.out.println("gyr位置：");
        for (int i=0;i<localGyro.length;i++){

            System.out.print(localGyro[i]+"  ");
        }

        for (int j=0;j<segNum-2;j++){
            ArrayList dataSegAccX = new ArrayList(),dataSegAccY= new ArrayList(),dataSegAccZ= new ArrayList(),dataSegGyroX= new ArrayList(),dataSegGyroY= new ArrayList(),dataSegGyroZ= new ArrayList();
            //鎴彇gyro鏁版嵁
            for (int i=localGyro[j];i<=localGyro[j+2];i++){
                dataSegGyroX.add(gyrX.get(i));
                dataSegGyroY.add(gyrY.get(i));
                dataSegGyroZ.add(gyrZ.get(i));
            }
            //鎴彇acc鏁版嵁
            for (int i=localAcc[j];i<=localAcc[j+2];i++){
                dataSegAccX.add(accX.get(i));
                dataSegAccY.add(accY.get(i));
                dataSegAccZ.add(accZ.get(i));
            }
//       if (j==0) {
//		System.out.println(dataSegGyroX.size()+" "+dataSegGyroX);
//	}
            //均方差
            feature[j] = StandardDeviation.getStandarDeviation(dataSegAccX);
            feature[j+(segNum-2)*1] = StandardDeviation.getStandarDeviation(dataSegAccY);
            feature[j+(segNum-2)*2] = StandardDeviation.getStandarDeviation(dataSegAccZ);
            feature[j+(segNum-2)*3] = StandardDeviation.getStandarDeviation(dataSegGyroX);
            feature[j+(segNum-2)*4] = StandardDeviation.getStandarDeviation(dataSegGyroY);
            feature[j+(segNum-2)*5] = StandardDeviation.getStandarDeviation(dataSegGyroZ);
            //相关系数
            feature[j+(segNum-2)*6] = PearsonsCorrelation.getCorrelation(ListToArray.getArray(dataSegAccX),ListToArray.getArray(dataSegAccY));
            feature[j+(segNum-2)*7] = PearsonsCorrelation.getCorrelation(ListToArray.getArray(dataSegAccX),ListToArray.getArray(dataSegAccZ));
            feature[j+(segNum-2)*8] = PearsonsCorrelation.getCorrelation(ListToArray.getArray(dataSegAccY),ListToArray.getArray(dataSegAccZ));
            feature[j+(segNum-2)*9] = PearsonsCorrelation.getCorrelation(ListToArray.getArray(dataSegGyroX),ListToArray.getArray(dataSegGyroY));
            feature[j+(segNum-2)*10] = PearsonsCorrelation.getCorrelation(ListToArray.getArray(dataSegGyroX),ListToArray.getArray(dataSegGyroZ));
            feature[j+(segNum-2)*11] = PearsonsCorrelation.getCorrelation(ListToArray.getArray(dataSegGyroY),ListToArray.getArray(dataSegGyroZ));

            //fft
            Complex[] fftAccX = Dft.directDft(ListToArray.getArray(dataSegAccX));
            Complex[] fftAccY = Dft.directDft(ListToArray.getArray(dataSegAccY));
            Complex[] fftAccZ = Dft.directDft(ListToArray.getArray(dataSegAccZ));
            Complex[] fftGyroX = Dft.directDft(ListToArray.getArray(dataSegGyroX));
            Complex[] fftGyroY = Dft.directDft(ListToArray.getArray(dataSegGyroY));
            Complex[] fftGyroZ = Dft.directDft(ListToArray.getArray(dataSegGyroZ));
            //得到实部
            double[] fftRealAccX = new double[fftAccX.length],fftRealAccY= new double[fftAccY.length],fftRealAccZ = new double[fftAccZ.length],
                    fftRealGyrX = new double[fftGyroX.length],fftRealGyrY= new double[fftGyroY.length],fftRealGyrZ= new double[fftGyroZ.length];
            for (int k=0;k<fftAccX.length;k++){
                fftRealAccX[k] = fftAccX[k].re()*2/fftAccX.length;
                fftRealAccY[k] = fftAccY[k].re()*2/fftAccY.length;
                fftRealAccZ[k] = fftAccZ[k].re()*2/fftAccZ.length;
            }
            for (int k=0;k<fftGyroX.length;k++){
                fftRealGyrX[k] = fftGyroX[k].re()*2/fftGyroX.length;
                fftRealGyrY[k] = fftGyroY[k].re()*2/fftGyroX.length;
                fftRealGyrZ[k] = fftGyroZ[k].re()*2/fftGyroX.length;
            }
            //能量
            feature[j+(segNum-2)*12] = Energy.getEnergy(fftRealAccX)/fftAccX.length;
            feature[j+(segNum-2)*13] = Energy.getEnergy(fftRealAccY)/fftAccX.length;
            feature[j+(segNum-2)*14] = Energy.getEnergy(fftRealAccZ)/fftAccX.length;
            feature[j+(segNum-2)*15] = Energy.getEnergy(fftRealGyrX)/fftRealGyrX.length;
            feature[j+(segNum-2)*16] = Energy.getEnergy(fftRealGyrY)/fftRealGyrX.length;
            feature[j+(segNum-2)*17] = Energy.getEnergy(fftRealGyrZ)/fftRealGyrX.length;
            //熵
            feature[j+(segNum-2)*18] = Ientropy.getEntropy(fftRealAccX,20);
            feature[j+(segNum-2)*19] = Ientropy.getEntropy(fftRealAccY,20);
            feature[j+(segNum-2)*20] = Ientropy.getEntropy(fftRealAccZ,20);
            feature[j+(segNum-2)*21] = Ientropy.getEntropy(fftRealGyrX,20);
            feature[j+(segNum-2)*22] = Ientropy.getEntropy(fftRealGyrY,20);
            feature[j+(segNum-2)*23] = Ientropy.getEntropy(fftRealGyrZ,20);
//            feature[j+(segNum-2)*18] = 0;
//            feature[j+(segNum-2)*19] = 0;
//            feature[j+(segNum-2)*20] = 0;
//            feature[j+(segNum-2)*21] = 0;
//            feature[j+(segNum-2)*22] = 0;
//            feature[j+(segNum-2)*23] = 0;
            //mean
            feature[j+(segNum-2)*24] = Average.getAverage(fftRealAccX);
            feature[j+(segNum-2)*25] = Average.getAverage(fftRealAccY);
            feature[j+(segNum-2)*26] = Average.getAverage(fftRealAccZ);
            feature[j+(segNum-2)*27] = Average.getAverage(fftRealGyrX);
            feature[j+(segNum-2)*28] = Average.getAverage(fftRealGyrY);
            feature[j+(segNum-2)*29] = Average.getAverage(fftRealGyrZ);

        }

        return feature;
    }

}
