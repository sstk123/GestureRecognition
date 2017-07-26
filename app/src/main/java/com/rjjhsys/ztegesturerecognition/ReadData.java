package com.rjjhsys.ztegesturerecognition;

import com.rjjhsys.ztegesturerecognition.FilterUtils.Filtfilt;
import com.rjjhsys.ztegesturerecognition.mathUtil.Standardlization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadData {

    public static double[][] readTemplate(String filePath) {
         double[] B = {3.11484171788834e-11, 3.11484171788834e-10, 1.40167877304975e-09, 3.73781006146601e-09, 6.54116760756551e-09, 7.84940112907862e-09, 6.54116760756551e-09, 3.73781006146601e-09, 1.40167877304975e-09, 3.11484171788834e-10, 3.11484171788834e-11};
         double[] A = {1, -8.79517034759317, 34.8749828194055, -82.0958968455894, 127.042943858756, -135.035542883992, 99.8350790400618, -50.6918184336482, 16.9167227917275, -3.35030544514359, 0.299005477912280};
          Filtfilt filtfilt = new Filtfilt();
        ArrayList BB = new ArrayList();
        ArrayList AA = new ArrayList();
        for (int i = 0; i < B.length; i++) {
            BB.add(B[i]);
            AA.add(A[i]);
        }
        ArrayList xList = new ArrayList<>();
    	ArrayList yList = new ArrayList<>();
    	ArrayList zList = new ArrayList<>();
    	try {
        	
        	int i=0;
            String encoding = "utf-8";
            System.out.println("read is "+filePath);
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read1 = new InputStreamReader(
                        new FileInputStream(file), encoding);

                BufferedReader bufferedReader1 = new BufferedReader(read1);
                String lineTxt = null;
                while ((lineTxt = bufferedReader1.readLine()) != null
                        && !lineTxt.equals("")) {

                            String aa[] = lineTxt.split(" ");
                            if (!aa[0].equals("")){
                            	xList.add(Double.parseDouble(aa[1])) ;
                                yList.add(Double.parseDouble(aa[2])) ;
                                zList.add(Double.parseDouble(aa[3])) ;


                            }

                }
                
                try {
                    bufferedReader1.close();
                } catch (IOException e) {
                    System.out.println("文件释放失败");
                }
            } else {
            	System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
        	System.out.println( "读取文件内容出错YYY");
            e.printStackTrace();
        }
//        System.out.println("readData64:"+filePath);
//        System.out.println(xList.size());
//        System.out.println(yList.size());
//        System.out.println(zList.size());
        xList = filtfilt.doFiltfilt(BB, AA, xList);
        yList = filtfilt.doFiltfilt(BB, AA, yList);
        zList = filtfilt.doFiltfilt(BB, AA, zList);

        double[][] data =new double[3][xList.size()];
        for (int i = 0; i < xList.size(); i++) {
			data[0][i] = Double.parseDouble(xList.get(i).toString());
			data[1][i] = Double.parseDouble(yList.get(i).toString());
			data[2][i] = Double.parseDouble(zList.get(i).toString());
		}
        data[0] = Standardlization.getStandardlization(data[0]);
        data[1] = Standardlization.getStandardlization(data[1]);
        data[2] = Standardlization.getStandardlization(data[2]);

        return data;

    }
}
