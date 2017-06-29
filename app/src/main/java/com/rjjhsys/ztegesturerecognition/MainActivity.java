package com.rjjhsys.ztegesturerecognition;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rjjhsys.ztegesturerecognition.DTWUtils.DTWcal;
import com.rjjhsys.ztegesturerecognition.FilterUtils.Filtfilt;
import com.rjjhsys.ztegesturerecognition.OtherUtils.DataBox;
import com.rjjhsys.ztegesturerecognition.OtherUtils.ListToArray;
import com.rjjhsys.ztegesturerecognition.WekaUtils.UseModelGesture;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import weka.classifiers.Classifier;
import weka.core.Instances;

public class MainActivity extends Activity {

    private Button buttonStatus;
    private boolean statusRecogbition = false;
    private SensorManager sensorManager;
    private Sensor sensorAcc, sensorGyr, sensorLacc;
    private ArrayList rawAccX = new ArrayList();
    private ArrayList rawAccY = new ArrayList();
    private ArrayList rawAccZ = new ArrayList();
    private ArrayList rawLaccX = new ArrayList();
    private ArrayList rawLaccY = new ArrayList();
    private ArrayList rawLaccZ = new ArrayList();
    private ArrayList rawGyrX = new ArrayList();
    private ArrayList rawGyrY = new ArrayList();
    private ArrayList rawGyrZ = new ArrayList();
    private double[] feature = new double[48];
    private Filtfilt filtfilt = new Filtfilt();
    private ArrayList accX = new ArrayList();
    private ArrayList accY = new ArrayList();
    private ArrayList accZ = new ArrayList();
    private ArrayList laccX = new ArrayList();
    private ArrayList laccY = new ArrayList();
    private ArrayList laccZ = new ArrayList();
    private ArrayList gyrX = new ArrayList();
    private ArrayList gyrY = new ArrayList();
    private ArrayList gyrZ = new ArrayList();
    private double[] B = {3.11484171788834e-11, 3.11484171788834e-10, 1.40167877304975e-09, 3.73781006146601e-09, 6.54116760756551e-09, 7.84940112907862e-09, 6.54116760756551e-09, 3.73781006146601e-09, 1.40167877304975e-09, 3.11484171788834e-10, 3.11484171788834e-11};
    private double[] A = {1, -8.79517034759317, 34.8749828194055, -82.0958968455894, 127.042943858756, -135.035542883992, 99.8350790400618, -50.6918184336482, 16.9167227917275, -3.35030544514359, 0.299005477912280};
    private ArrayList BB = new ArrayList();
    private ArrayList AA = new ArrayList();
    private Classifier classifierGesture;
    static UseModelGesture useModelGesture = new UseModelGesture();
    public Instances instancesGesture = UseModelGesture.getInstances();//得到创建的实例,往实例里面加instance，就可以对实例进行预测。
    private static int instanceNum = 0;
    private ProgressBar progressBar;
    private int progNum = 0;
    private TextView showResult;
    String resultString = "识别结果：\n";
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
        sensorLacc = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorManager.registerListener(myListener, sensorAcc, 8333);
        sensorManager.registerListener(myListener, sensorGyr, 8333);
        sensorManager.registerListener(myListener, sensorLacc, 8333);
        buttonStatus = (Button) findViewById(R.id.statusButton);
        buttonStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonStatus.getText().equals("开始手势识别")) {
                    buttonStatus.setText("正在识别中ing!!!");
                } else {
                    buttonStatus.setText("开始手势识别");
                    resultString = "识别结果：\n";
                }

            }
        });
        for (int i = 0; i < B.length; i++) {
            BB.add(B[i]);
            AA.add(A[i]);
        }
        loadData();
        Toast.makeText(this, "load data suceess!!!", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
//        o1,o2,o3,e1,e2,e3,v1,v2,v3,u1,u2,u3,w1,w2,w3,y1,y2,y3,c1,c2,c3
       try {
            classifierGesture = useModelGesture.getClassifier("//Liuwu//0626.model");//在程序在进行初始化的时候，就进行模型的引入
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        progNum = 16;
        progressBar.setProgress(progNum);
        String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String FILE_NAME2 = "/Liuwu/template2/";
        String fpath = sdPath + FILE_NAME2;
        File file = new File(fpath);
        String f[] = new String[21];
        f[0] = fpath.toString() + "u1." + suffix;
        f[1] = fpath.toString() + "u2." + suffix;
        f[2] = fpath.toString() + "u3." + suffix;
        f[3] = fpath.toString() + "w1." + suffix;
        f[4] = fpath.toString() + "w2." + suffix;
        f[5] = fpath.toString() + "w3." + suffix;
        f[6] = fpath.toString() + "y1." + suffix;
        f[7] = fpath.toString() + "y2." + suffix;
        f[8] =  fpath.toString() + "y3." + suffix;
        f[9] =  fpath.toString() + "c1." + suffix;
        f[10] = fpath.toString() + "c2." + suffix;
        f[11] = fpath.toString() + "c3." + suffix;
        f[12] = fpath.toString() + "e1." + suffix;
        f[13] = fpath.toString() + "e2." + suffix;
        f[14] = fpath.toString() + "e3." + suffix;
        f[15] = fpath.toString() + "o1." + suffix;
        f[16] = fpath.toString() + "o2." + suffix;
        f[17] = fpath.toString() + "o3." + suffix;
        f[18] = fpath.toString() + "v1." + suffix;
        f[19] = fpath.toString() + "v2." + suffix;
        f[20] = fpath.toString() + "v3." + suffix;


        for (String s:f){
            System.out.println(s.toString());
        }

for (String s:f){
    System.out.println(s);
}
        MyApplication.u1 = ReadData.readTemplate(f[0]);
        MyApplication.u2 = ReadData.readTemplate(f[1]);
        MyApplication.u3 = ReadData.readTemplate(f[2]);
        MyApplication.w1 = ReadData.readTemplate(f[3]);
        MyApplication.w2 = ReadData.readTemplate(f[4]);
        MyApplication.w3 = ReadData.readTemplate(f[5]);
        MyApplication.y1 = ReadData.readTemplate(f[6]);
        MyApplication.y2 = ReadData.readTemplate(f[7]);
        MyApplication.y3 = ReadData.readTemplate(f[8]);
        MyApplication.c1 = ReadData.readTemplate(f[9]);
        MyApplication.c2 = ReadData.readTemplate(f[10]);
        MyApplication.c3 = ReadData.readTemplate(f[11]);
        MyApplication.e1 = ReadData.readTemplate(f[12]);
        MyApplication.e2 = ReadData.readTemplate(f[13]);
        MyApplication.e3 = ReadData.readTemplate(f[14]);
        MyApplication.o1 = ReadData.readTemplate(f[15]);
        MyApplication.o2 = ReadData.readTemplate(f[16]);
        MyApplication.o3 = ReadData.readTemplate(f[17]);
        MyApplication.v1 = ReadData.readTemplate(f[18]);
        MyApplication.v2 = ReadData.readTemplate(f[19]);
        MyApplication.v3 = ReadData.readTemplate(f[20]);
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
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    if (statusRecogbition == true && buttonStatus.getText().equals("正在识别中ing!!!")) {
                        rawLaccX.add((double) event.values[0]);
                        rawLaccY.add((double) event.values[1]);
                        rawLaccZ.add((double) event.values[2]);
                    }
                    break;
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


        double result = 0;//得到结果索引
        //滤波
        accX =  filtfilt.doFiltfilt(BB, AA, rawAccX);
        accY =  filtfilt.doFiltfilt(BB, AA, rawAccY);
        accZ =  filtfilt.doFiltfilt(BB, AA, rawAccZ);
        laccX = filtfilt.doFiltfilt(BB, AA, rawLaccX);
        laccY = filtfilt.doFiltfilt(BB, AA, rawLaccY);
        laccZ = filtfilt.doFiltfilt(BB, AA, rawLaccZ);
        gyrX =  filtfilt.doFiltfilt(BB, AA, rawGyrX);
        gyrY =  filtfilt.doFiltfilt(BB, AA, rawGyrY);
        gyrZ =  filtfilt.doFiltfilt(BB, AA, rawGyrZ);
        char dtwResult = 'q';
        if (suffix.equals("lacc")){
         dtwResult = DTWcal.getDTWselect(DataBox.DataBoxHandle(ListToArray.getArray(laccX)), DataBox.DataBoxHandle(ListToArray.getArray(laccY)), DataBox.DataBoxHandle(ListToArray.getArray(laccZ)));


        }else{
            dtwResult = DTWcal.getDTWselect(ListToArray.getArray(gyrX), ListToArray.getArray(gyrY), ListToArray.getArray(gyrZ));

        }


        if (dtwResult == 'q') {
            resultString = resultString + "没有识别出来 \n";
            showResult.setText(resultString);
        }
        System.out.println("DTW的结果是：" + dtwResult);


        //特征提取
        feature = FeatureExtract.getFeature(accX, accY, accZ, gyrX, gyrY, gyrZ);

        //创建实例
        instancesGesture = UseModelGesture.createNewInstances(instancesGesture, feature);
        instanceNum++;

        //识别
        try {
            result = classifierGesture.classifyInstance(instancesGesture.instance(instanceNum - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* 'O'  = 0; 'C' = 1; 'e' = 2; 'V' = 3; 'U'= 4; 'W' = 5; 'y' = 6; * */
        String resultType = (String) instancesGesture.classAttribute().value((int) result);
        char[] resultType2 = resultType.toCharArray();
        switch (resultType2[0]) {
            case '0':
                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString = resultString + "DTW识别结果是：" + String.valueOf(dtwResult) + "        RF识别结果是：O \n";
                showResult.setText(resultString);
                break;
            case '1':
                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString = resultString + "DTW识别结果是：" +  String.valueOf(dtwResult) + "        RF识别结果是：C \n";
                showResult.setText(resultString);
                break;
            case '2':
                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString = resultString + "DTW识别结果是：" +  String.valueOf(dtwResult) + "        RF识别结果是：e \n";
                showResult.setText(resultString);
                break;
            case '3':
                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString = resultString + "DTW识别结果是：" +  String.valueOf(dtwResult) + "        RF识别结果是：V \n";
                showResult.setText(resultString);
                break;
            case '4':
                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString = resultString + "DTW识别结果是：" +  String.valueOf(dtwResult) + "        RF识别结果是：U \n";
                showResult.setText(resultString);
                break;
            case '5':
                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString = resultString + "DTW识别结果是：" +  String.valueOf(dtwResult) + "        RF识别结果是：W \n";
                showResult.setText(resultString);
                break;
            case '6':
                Toast.makeText(this, String.valueOf(dtwResult), Toast.LENGTH_SHORT).show();
                resultString = resultString + "DTW识别结果是：" +  String.valueOf(dtwResult) + "        RF识别结果是：y \n";
                showResult.setText(resultString);
                break;
        }
        listClear();
    }


    //清除上次识别产生的数据
    private void listClear() {
        rawAccX.clear();      rawAccY.clear();       rawAccZ.clear();
        rawGyrX.clear();      rawGyrY.clear();       rawGyrZ.clear();
        rawLaccX.clear();     rawLaccY.clear();      rawLaccZ.clear();
        accX.clear();          accY.clear();          accZ.clear();
        laccX.clear();         laccY.clear();         laccZ.clear();
        gyrX.clear();          gyrY.clear();          gyrZ.clear();

    }
}
