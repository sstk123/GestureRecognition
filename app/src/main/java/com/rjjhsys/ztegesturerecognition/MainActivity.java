package com.rjjhsys.ztegesturerecognition;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.rjjhsys.ztegesturerecognition.FilterUtils.Filtfilt;

import com.rjjhsys.ztegesturerecognition.WekaUtils.UseModelGesture2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class MainActivity extends Activity {

    private Button buttonStatus;
    private boolean statusRecogbition = false;
    private SensorManager sensorManager;
    private Sensor sensorAcc, sensorGyr, sensorLacc;
    private ArrayList rawAccX = new ArrayList();
    private ArrayList rawAccY = new ArrayList();
    private ArrayList rawAccZ = new ArrayList();
//    private ArrayList rawLaccX = new ArrayList();
//    private ArrayList rawLaccY = new ArrayList();
//    private ArrayList rawLaccZ = new ArrayList();
    private ArrayList rawGyrX = new ArrayList();
    private ArrayList rawGyrY = new ArrayList();
    private ArrayList rawGyrZ = new ArrayList();
    private double[] feature = new double[210];
    private Filtfilt filtfilt = new Filtfilt();
    private ArrayList accX = new ArrayList();
    private ArrayList accY = new ArrayList();
    private ArrayList accZ = new ArrayList();
//    private ArrayList laccX = new ArrayList();
//    private ArrayList laccY = new ArrayList();
//    private ArrayList laccZ = new ArrayList();
//    private ArrayList gyrX2 = new ArrayList();
//    private ArrayList gyrY2 = new ArrayList();
//    private ArrayList gyrZ2 = new ArrayList();
    private ArrayList gyrX = new ArrayList();
    private ArrayList gyrY = new ArrayList();
    private ArrayList gyrZ = new ArrayList();
//    private double[] B = {3.11484171788834e-11, 3.11484171788834e-10, 1.40167877304975e-09, 3.73781006146601e-09, 6.54116760756551e-09, 7.84940112907862e-09, 6.54116760756551e-09, 3.73781006146601e-09, 1.40167877304975e-09, 3.11484171788834e-10, 3.11484171788834e-11};
//    private double[] A = {1, -8.79517034759317, 34.8749828194055, -82.0958968455894, 127.042943858756, -135.035542883992, 99.8350790400618, -50.6918184336482, 16.9167227917275, -3.35030544514359, 0.299005477912280};
    private double[] B2 = {5.51450551888877e-12,5.51450551888877e-11,2.48152748349995e-10,6.61740662266652e-10,1.15804615896664e-09,1.38965539075997e-09,1.15804615896664e-09,6.61740662266652e-10,2.48152748349995e-10,5.51450551888877e-11,5.51450551888877e-12};
    private double[] A2 = {1,-8.99594505535417,36.4633075498862,-87.6908102873418,138.559912556039,-150.302116273606,113.348650426591,-58.6790854259776,19.9562604962225,-4.02604302102184,0.365869040210561};
    private ArrayList BB = new ArrayList();
    private ArrayList AA = new ArrayList();
    private Classifier classifierGesture;
    static UseModelGesture2 UseModelGesture2 = new UseModelGesture2();
    public Instances instancesGesture = UseModelGesture2.getInstances();//得到创建的实例,往实例里面加instance，就可以对实例进行预测。
    private static int instanceNum = 0;
    private ProgressBar progressBar;
    private int progNum = 0;
    private TextView showResult;
    StringBuilder resultString = new StringBuilder() ;
    private String suffix = "gyro";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar.setIndeterminate(false);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setMax(100);
        progressBar.setProgress(progNum);
        showResult = (TextView) findViewById(R.id.show_result);


        instancesGesture.setClassIndex(instancesGesture.numAttributes() - 1);

        //传感器注册
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorAcc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorGyr = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
//        sensorLacc = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorManager.registerListener(myListener, sensorAcc, 8333);
        sensorManager.registerListener(myListener, sensorGyr, 8333);
//        sensorManager.registerListener(myListener, sensorLacc, 8333);
        buttonStatus = (Button) findViewById(R.id.statusButton);
        buttonStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonStatus.getText().equals("开始手势识别")) {
                    buttonStatus.setText("正在识别中ing!!!");
                } else {
                    buttonStatus.setText("开始手势识别");
                    resultString.delete(0,resultString.length());
                    resultString.append("识别结果：\n");
                    resultString.delete(0,resultString.length());

                }

            }
        });
        for (int i = 0; i < B2.length; i++) {
            BB.add(B2[i]);
            AA.add(A2[i]);
        }
        loadData();
        Toast.makeText(this, "load data suceess!!!", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
//        o1,o2,o3,e1,e2,e3,v1,v2,v3,u1,u2,u3,w1,w2,w3,y1,y2,y3,c1,c2,c3
//       try {
//            classifierGesture = UseModelGesture2.getClassifier("//Liuwu//RF0709.model");//在程序在进行初始化的时候，就进行模型的引入

           try {
               classifierGesture = UseModelGesture2.getClassifier(getAssets().open("RF0725-7ges.model"));
           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
        progNum = 16;
        progressBar.setProgress(progNum);
//        String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
//        String FILE_NAME2 = "/Liuwu/template4/";
//        String fpath = sdPath + FILE_NAME2;
//        File file = new File(fpath);
//        String f[] = new String[24];
//        String f2[] =  new String[19];
//        f[0] = fpath.toString() + "V1." + suffix;
//        f[1] = fpath.toString() + "V2." + suffix;
//        f[2] = fpath.toString() + "V3." + suffix;
//        f[3] = fpath.toString() + "V4." + suffix;
//        f[4] = fpath.toString() + "V5." + suffix;
//        f[5] = fpath.toString() + "V6." + suffix;
//        f[6] = fpath.toString() + "V7." + suffix;
//        f[7] = fpath.toString() + "V8." + suffix;
//        f[8] =  fpath.toString() + "V9." + suffix;
//        f[9] =  fpath.toString() + "V10." + suffix;
//        f[10] = fpath.toString() + "V11." + suffix;
//        f[11] = fpath.toString() + "V12." + suffix;
//        f[12] = fpath.toString() + "V13." + suffix;
//        f[13] = fpath.toString() + "V14." + suffix;
//        f[14] = fpath.toString() + "V15." + suffix;
//        f[15] = fpath.toString() + "V16." + suffix;
//        f[16] = fpath.toString() + "V17." + suffix;
//        f[17] = fpath.toString() + "V18." + suffix;
//        f[18] = fpath.toString() + "V19." + suffix;
//        f[19] = fpath.toString() + "V20." + suffix;
//        f[20] = fpath.toString() + "V21." + suffix;
//        f[21] = fpath.toString() + "V22." + suffix;
//        f[22] = fpath.toString() + "V23." + suffix;
//        f[23] = fpath.toString() + "V24." + suffix;
//
//        f2[0] = fpath.toString() + "O1." + suffix;
//        f2[1] = fpath.toString() + "O2." + suffix;
//        f2[2] = fpath.toString() + "O3." + suffix;
//        f2[3] = fpath.toString() + "O4." + suffix;
//        f2[4] = fpath.toString() + "O5." + suffix;
//        f2[5] = fpath.toString() + "O6." + suffix;
//        f2[6] = fpath.toString() + "O7." + suffix;
//        f2[7] = fpath.toString() + "O8." + suffix;
//        f2[8] = fpath.toString() + "O9." + suffix;
//        f2[9] = fpath.toString() + "O10." + suffix;
//        f2[10] = fpath.toString() + "O11." + suffix;
//        f2[11] = fpath.toString() + "O12." + suffix;
//        f2[12] = fpath.toString() + "O13." + suffix;
//        f2[13] = fpath.toString() + "O14." + suffix;
//        f2[14] = fpath.toString() + "O15." + suffix;
//        f2[15] = fpath.toString() + "O16." + suffix;
//        f2[16] = fpath.toString() + "O17." + suffix;
//        f2[17] = fpath.toString() + "O18." + suffix;
//
//
//
//        MyApplication.V1 = ReadData.readTemplate(f[0]);
//        MyApplication.V2 = ReadData.readTemplate(f[1]);
//        MyApplication.V3 = ReadData.readTemplate(f[2]);
//        MyApplication.V4 = ReadData.readTemplate(f[3]);
//        MyApplication.V5 = ReadData.readTemplate(f[4]);
//        MyApplication.V6 = ReadData.readTemplate(f[5]);
//        MyApplication.V7 = ReadData.readTemplate(f[6]);
//        MyApplication.V8 = ReadData.readTemplate(f[7]);
//        MyApplication.V9 = ReadData.readTemplate(f[8]);
//        MyApplication.V10 = ReadData.readTemplate(f[9]);
//        MyApplication.V11 = ReadData.readTemplate(f[10]);
//        MyApplication.V12 = ReadData.readTemplate(f[11]);
//        MyApplication.V13 = ReadData.readTemplate(f[12]);
//        MyApplication.V14 = ReadData.readTemplate(f[13]);
//        MyApplication.V15 = ReadData.readTemplate(f[14]);
//        MyApplication.V16 = ReadData.readTemplate(f[15]);
//        MyApplication.V17 = ReadData.readTemplate(f[16]);
//        MyApplication.V18 = ReadData.readTemplate(f[17]);
//        MyApplication.V19 = ReadData.readTemplate(f[18]);
//        MyApplication.V20 = ReadData.readTemplate(f[19]);
//        MyApplication.V21 = ReadData.readTemplate(f[20]);
//        MyApplication.V22 = ReadData.readTemplate(f[21]);
//        MyApplication.V23 = ReadData.readTemplate(f[22]);
//        MyApplication.V24 = ReadData.readTemplate(f[23]);
//
//        MyApplication.O1 = ReadData.readTemplate(f2[0]);
//        MyApplication.O2 = ReadData.readTemplate(f2[1]);
//        MyApplication.O3 = ReadData.readTemplate(f2[2]);
//        MyApplication.O4 = ReadData.readTemplate(f2[3]);
//        MyApplication.O5 = ReadData.readTemplate(f2[4]);
//        MyApplication.O6 = ReadData.readTemplate(f2[5]);
//        MyApplication.O7 = ReadData.readTemplate(f2[6]);
//        MyApplication.O8 = ReadData.readTemplate(f2[7]);
//        MyApplication.O9 = ReadData.readTemplate(f2[8]);
//        MyApplication.O10 = ReadData.readTemplate(f2[9]);
//        MyApplication.O11 = ReadData.readTemplate(f2[10]);
//        MyApplication.O12 = ReadData.readTemplate(f2[11]);
//        MyApplication.O13 = ReadData.readTemplate(f2[12]);
//        MyApplication.O14 = ReadData.readTemplate(f2[13]);
//        MyApplication.O15 = ReadData.readTemplate(f2[14]);
//        MyApplication.O16 = ReadData.readTemplate(f2[15]);
//        MyApplication.O17 = ReadData.readTemplate(f2[16]);
//        MyApplication.O18 = ReadData.readTemplate(f2[17]);

        progNum = 100;
        progressBar.setProgress(progNum);

    }

    final SensorEventListener myListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            switch (event.sensor.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    if (statusRecogbition == true && buttonStatus.getText().equals("正在识别中ing!!!")) {
                        rawAccX.add((double) event.values[0]);
                        rawAccY.add((double) event.values[1]);
                        rawAccZ.add((double) event.values[2]);
                    }
                    break;
//                case Sensor.TYPE_LINEAR_ACCELERATION:
//                    if (statusRecogbition == true && buttonStatus.getText().equals("正在识别中ing!!!")) {
//                        rawLaccX.add((double) event.values[0]);
//                        rawLaccY.add((double) event.values[1]);
//                        rawLaccZ.add((double) event.values[2]);
//                    }
//                    break;
                case Sensor.TYPE_GYROSCOPE:
                    if (statusRecogbition == true && buttonStatus.getText().equals("正在识别中ing!!!")) {
                        rawGyrX.add((double) event.values[0]);
                        rawGyrY.add((double) event.values[1]);
                        rawGyrZ.add((double) event.values[2]);
                    }
                    break;
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();

        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                statusRecogbition = true;
                break;
            case MotionEvent.ACTION_UP:
                statusRecogbition = false;
                if (buttonStatus.getText().equals("正在识别中ing!!!")) {
                    deal();//此处进行数据处理，特征提取+模型识别
                }
                break;
        }
        return true;
    }

    private void deal() {
        double result = 9;//得到结果索引
        //滤波
        System.out.println("原始数据：");
        System.out.println(rawAccX);
        accX =  filtfilt.doFiltfilt(BB, AA, rawAccX);
        accY =  filtfilt.doFiltfilt(BB, AA, rawAccY);
        accZ =  filtfilt.doFiltfilt(BB, AA, rawAccZ);
//        laccX = filtfilt.doFiltfilt(BB, AA, rawLaccX);
//        laccY = filtfilt.doFiltfilt(BB, AA, rawLaccY);
//        laccZ = filtfilt.doFiltfilt(BB, AA, rawLaccZ);
        gyrX =  filtfilt.doFiltfilt(BB, AA, rawGyrX);
        gyrY =  filtfilt.doFiltfilt(BB, AA, rawGyrY);
        gyrZ =  filtfilt.doFiltfilt(BB, AA, rawGyrZ);
        System.out.println("raw:");
        System.out.println(rawAccX);
        System.out.println(rawAccY);
        System.out.println(rawAccZ);
        System.out.println(rawGyrX);
        System.out.println(rawGyrY);
        System.out.println(rawGyrZ);


        //特征提取
        feature = FeatureExtract2.getFeature(accX, accY, accZ, gyrX, gyrY, gyrZ);
        System.out.println();

        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<feature.length;i++){
            stringBuffer.append(feature[i]+",");
        }
        System.out.println(stringBuffer.toString());
//        WriteFile.write(stringBuffer.toString()+"\r","//Liuwu//feature.txt");

        //创建实例
        instancesGesture = UseModelGesture2.createNewInstances(instancesGesture, feature);
        instanceNum++;
               //识别
        try {

            result = classifierGesture.classifyInstance(instancesGesture.instance(instanceNum - 1));
        } catch (Exception e) {

            resultString.append( "        识别结果是：发生error \n");
            e.printStackTrace();
        }finally {
            listClear();
        }
        System.out.println("机器学习返回的是"+result);
//        System.out.println(result);
        /* 'O'  = 0; 'C' = 1; 'e' = 2; 'V' = 3; 'U'= 4; 'W' = 5; 'y' = 6; * */
        String resultType = (String) instancesGesture.classAttribute().value((int) result);
        char[] resultType2 = resultType.toCharArray();
        System.out.println("000..."+resultType.toString());
        /* 'O'  = 0; 'C' = 1; 'e' = 2; 'V' = 3; 'U'= 4; 'W' = 5; 'y' = 6; * */
        switch (resultType2[0]) {
            case 'r':
//                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString.append( "        识别结果是：O \n");
                showResult.setText(resultString);
                break;
            case 'N':
//                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString.append( "        识别结果是：NAN \n");
                showResult.setText(resultString);
                break;
            case '0':
//                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString.append( "        识别结果是：O \n");
                showResult.setText(resultString);
                break;
            case '1':

                resultString.append( "        识别结果是：C \n");
                showResult.setText(resultString);
                break;
            case '2':
                resultString.append(  "        识别结果是：e\n");
                showResult.setText(resultString);
                break;
            case '3':
                resultString.append(   "        识别结果是：V \n");
                showResult.setText(resultString);

                break;
            case '4':
                resultString.append(  "        识别结果是：U \n");
                showResult.setText(resultString);
                break;
            case '5':
                resultString.append(  "        识别结果是：W \n");
                showResult.setText(resultString);
                break;
            case '6':
                resultString.append( "        识别结果是：y \n");
                showResult.setText(resultString);
                break;
            case '9':
                resultString.append( "        error!!!\n");
                showResult.setText(resultString);
                break;
        }

    }


    //清除上次识别产生的数据
    private void listClear() {
        rawAccX.clear();      rawAccY.clear();       rawAccZ.clear();
        rawGyrX.clear();      rawGyrY.clear();       rawGyrZ.clear();
//        rawLaccX.clear();     rawLaccY.clear();      rawLaccZ.clear();
        accX.clear();         accY.clear();          accZ.clear();
//        laccX.clear();        laccY.clear();         laccZ.clear();
        gyrX.clear();         gyrY.clear();          gyrZ.clear();

    }
}
