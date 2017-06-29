package com.rjjhsys.ztegesturerecognition.WekaUtils;
/*
* 包含身高的步长估计
* */

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

public class UseModelGesture {
    public static Instances getInstances(){
        Instances data;
        //进行实例的初始化等操作
        FastVector fastVector = new FastVector();
        //进行属性的添加

        fastVector.addElement(new Attribute("maxAccX"));
        fastVector.addElement(new Attribute("maxAccY"));
        fastVector.addElement(new Attribute("maxAccZ"));
        fastVector.addElement(new Attribute("maxGyrX"));
        fastVector.addElement(new Attribute("maxGyrY"));
        fastVector.addElement(new Attribute("maxGyrZ"));

        fastVector.addElement(new Attribute("minAccX"));
        fastVector.addElement(new Attribute("minAccY"));
        fastVector.addElement(new Attribute("minAccZ"));
        fastVector.addElement(new Attribute("minGyrX"));
        fastVector.addElement(new Attribute("minGyrY"));
        fastVector.addElement(new Attribute("minGyrZ"));

        fastVector.addElement(new Attribute("valleyAccX"));
        fastVector.addElement(new Attribute("valleyAccY"));
        fastVector.addElement(new Attribute("valleyAccZ"));
        fastVector.addElement(new Attribute("valleyGyrX"));
        fastVector.addElement(new Attribute("valleyGyrY"));
        fastVector.addElement(new Attribute("valleyGyrZ"));

        fastVector.addElement(new Attribute("energyAccX"));
        fastVector.addElement(new Attribute("energyAccY"));
        fastVector.addElement(new Attribute("energyAccZ"));
        fastVector.addElement(new Attribute("energyGyrX"));
        fastVector.addElement(new Attribute("energyGyrY"));
        fastVector.addElement(new Attribute("energyGyrZ"));

        fastVector.addElement(new Attribute("peakAccX"));
        fastVector.addElement(new Attribute("peakAccY"));
        fastVector.addElement(new Attribute("peakAccZ"));
        fastVector.addElement(new Attribute("peakGyrX"));
        fastVector.addElement(new Attribute("peakGyrY"));
        fastVector.addElement(new Attribute("peakGyrZ"));

        fastVector.addElement(new Attribute("rmsAccX"));
        fastVector.addElement(new Attribute("rmsAccY"));
        fastVector.addElement(new Attribute("rmsAccZ"));
        fastVector.addElement(new Attribute("rmsGyrX"));
        fastVector.addElement(new Attribute("rmsGyrY"));
        fastVector.addElement(new Attribute("rmsGyrZ"));

        fastVector.addElement(new Attribute("stdAccX"));
        fastVector.addElement(new Attribute("stdAccY"));
        fastVector.addElement(new Attribute("stdAccZ"));
        fastVector.addElement(new Attribute("stdGyrX"));
        fastVector.addElement(new Attribute("stdGyrY"));
        fastVector.addElement(new Attribute("stdGyrZ"));

        fastVector.addElement(new Attribute("varAccX"));
        fastVector.addElement(new Attribute("varAccY"));
        fastVector.addElement(new Attribute("varAccZ"));
        fastVector.addElement(new Attribute("varGyrX"));
        fastVector.addElement(new Attribute("varGyrY"));
        fastVector.addElement(new Attribute("varGyrZ"));

        fastVector.addElement(new Attribute("type", getClassFastVector()));
        //进行实例加入属性
        data = new Instances("Mydata",fastVector,0);
        //下面加入数据

        return data;
    }
    //创建instance
    public static Instances createNewInstances (Instances instances,double[] valueIn){
        double[] value = new double[instances.numAttributes()];

        for (int i=0;i<(instances.numAttributes()-1);i++){
            value[i] = valueIn[i];
        }
        value[48] = getClassFastVector().indexOf("0");
        instances.add(new Instance(1.0,value));
        System.out.println("use91--"+instances.numInstances());
        return instances;
    }

    public static FastVector getClassFastVector(){
        FastVector fastVector = new FastVector();
        //下面加入class的值,下面列举了四类数据
        fastVector.addElement("0");
        fastVector.addElement("1");
        fastVector.addElement("2");
        fastVector.addElement("3");
        fastVector.addElement("4");
        fastVector.addElement("5");
        fastVector.addElement("6");

        return fastVector;
    }



    public Classifier getClassifier(String fileAddress) throws IOException, ClassNotFoundException {//进行model文件的读入，以及模型的返回
        File sdfile = Environment.getExternalStorageDirectory();//内存地址
        Classifier classifier = (Classifier) (new ObjectInputStream(new FileInputStream(new File(sdfile,fileAddress)))).readObject();//进行文件转化为模型
        return classifier;
    }
}
