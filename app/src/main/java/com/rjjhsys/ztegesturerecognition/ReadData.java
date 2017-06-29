package com.rjjhsys.ztegesturerecognition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadData {

    public static double[][] readTemplate(String filePath) {
    	ArrayList xList = new ArrayList<>();
    	ArrayList yList = new ArrayList<>();
    	ArrayList zList = new ArrayList<>();
    	try {
        	
        	int i=0;
            String encoding = "utf-8";
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
                            	xList.add(aa[1]);
                            	yList.add(aa[2]);
                            	zList.add(aa[3]);

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
        double[][] data =new double[3][xList.size()];
        for (int i = 0; i < xList.size(); i++) {
			data[0][i] = Double.parseDouble(xList.get(i).toString());
			data[1][i] = Double.parseDouble(yList.get(i).toString());
			data[2][i] = Double.parseDouble(zList.get(i).toString());
		}
		return data;

    }
}
