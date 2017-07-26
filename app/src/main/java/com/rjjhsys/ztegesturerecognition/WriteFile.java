package com.rjjhsys.ztegesturerecognition;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by gongyan on 2017/7/8.
 */

public class WriteFile {

    public static void write(String str,String filePath){
        File sdfile = Environment.getExternalStorageDirectory();//内存地址
        File file =new File(sdfile,filePath);
        FileWriter fileWriter;
        try {
             fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
