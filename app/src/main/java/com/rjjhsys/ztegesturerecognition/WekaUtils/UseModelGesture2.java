package com.rjjhsys.ztegesturerecognition.WekaUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instances;

public class UseModelGesture2 {
    public static Instances getInstances(){
        Instances data;
        //进行实例的初始化等操作
        FastVector fastVector = new FastVector();
        //进行属性的添加

        fastVector.addElement(new Attribute("A1"));
        fastVector.addElement(new Attribute("A2"));
        fastVector.addElement(new Attribute("A3"));
        fastVector.addElement(new Attribute("A4"));
        fastVector.addElement(new Attribute("A5"));
        fastVector.addElement(new Attribute("A6"));
        fastVector.addElement(new Attribute("A7"));
        fastVector.addElement(new Attribute("A8"));
        fastVector.addElement(new Attribute("A9"));
        fastVector.addElement(new Attribute("A10"));
        fastVector.addElement(new Attribute("A11"));
        fastVector.addElement(new Attribute("A12"));
        fastVector.addElement(new Attribute("A13"));
        fastVector.addElement(new Attribute("A14"));
        fastVector.addElement(new Attribute("A15"));
        fastVector.addElement(new Attribute("A16"));
        fastVector.addElement(new Attribute("A17"));
        fastVector.addElement(new Attribute("A18"));
        fastVector.addElement(new Attribute("A19"));
        fastVector.addElement(new Attribute("A20"));
        fastVector.addElement(new Attribute("A21"));
        fastVector.addElement(new Attribute("A22"));
        fastVector.addElement(new Attribute("A23"));
        fastVector.addElement(new Attribute("A24"));
        fastVector.addElement(new Attribute("A25"));
        fastVector.addElement(new Attribute("A26"));
        fastVector.addElement(new Attribute("A27"));
        fastVector.addElement(new Attribute("A28"));
        fastVector.addElement(new Attribute("A29"));
        fastVector.addElement(new Attribute("A30"));
        fastVector.addElement(new Attribute("A31"));
        fastVector.addElement(new Attribute("A32"));
        fastVector.addElement(new Attribute("A33"));
        fastVector.addElement(new Attribute("A34"));
        fastVector.addElement(new Attribute("A35"));
        fastVector.addElement(new Attribute("A36"));
        fastVector.addElement(new Attribute("A37"));
        fastVector.addElement(new Attribute("A38"));
        fastVector.addElement(new Attribute("A39"));
        fastVector.addElement(new Attribute("A40"));
        fastVector.addElement(new Attribute("A41"));
        fastVector.addElement(new Attribute("A42"));
        fastVector.addElement(new Attribute("A43"));
        fastVector.addElement(new Attribute("A44"));
        fastVector.addElement(new Attribute("A45"));
        fastVector.addElement(new Attribute("A46"));
        fastVector.addElement(new Attribute("A47"));
        fastVector.addElement(new Attribute("A48"));
        fastVector.addElement(new Attribute("A49"));
        fastVector.addElement(new Attribute("A50"));
        fastVector.addElement(new Attribute("A51"));
        fastVector.addElement(new Attribute("A52"));
        fastVector.addElement(new Attribute("A53"));
        fastVector.addElement(new Attribute("A54"));
        fastVector.addElement(new Attribute("A55"));
        fastVector.addElement(new Attribute("A56"));
        fastVector.addElement(new Attribute("A57"));
        fastVector.addElement(new Attribute("A58"));
        fastVector.addElement(new Attribute("A59"));
        fastVector.addElement(new Attribute("A60"));
        fastVector.addElement(new Attribute("A61"));
        fastVector.addElement(new Attribute("A62"));
        fastVector.addElement(new Attribute("A63"));
        fastVector.addElement(new Attribute("A64"));
        fastVector.addElement(new Attribute("A65"));
        fastVector.addElement(new Attribute("A66"));
        fastVector.addElement(new Attribute("A67"));
        fastVector.addElement(new Attribute("A68"));
        fastVector.addElement(new Attribute("A69"));
        fastVector.addElement(new Attribute("A70"));
        fastVector.addElement(new Attribute("A71"));
        fastVector.addElement(new Attribute("A72"));
        fastVector.addElement(new Attribute("A73"));
        fastVector.addElement(new Attribute("A74"));
        fastVector.addElement(new Attribute("A75"));
        fastVector.addElement(new Attribute("A76"));
        fastVector.addElement(new Attribute("A77"));
        fastVector.addElement(new Attribute("A78"));
        fastVector.addElement(new Attribute("A79"));
        fastVector.addElement(new Attribute("A80"));
        fastVector.addElement(new Attribute("A81"));
        fastVector.addElement(new Attribute("A82"));
        fastVector.addElement(new Attribute("A83"));
        fastVector.addElement(new Attribute("A84"));
        fastVector.addElement(new Attribute("A85"));
        fastVector.addElement(new Attribute("A86"));
        fastVector.addElement(new Attribute("A87"));
        fastVector.addElement(new Attribute("A88"));
        fastVector.addElement(new Attribute("A89"));
        fastVector.addElement(new Attribute("A90"));
        fastVector.addElement(new Attribute("A91"));
        fastVector.addElement(new Attribute("A92"));
        fastVector.addElement(new Attribute("A93"));
        fastVector.addElement(new Attribute("A94"));
        fastVector.addElement(new Attribute("A95"));
        fastVector.addElement(new Attribute("A96"));
        fastVector.addElement(new Attribute("A97"));
        fastVector.addElement(new Attribute("A98"));
        fastVector.addElement(new Attribute("A99"));
        fastVector.addElement(new Attribute("A100"));
        fastVector.addElement(new Attribute("A101"));
        fastVector.addElement(new Attribute("A102"));
        fastVector.addElement(new Attribute("A103"));
        fastVector.addElement(new Attribute("A104"));
        fastVector.addElement(new Attribute("A105"));
        fastVector.addElement(new Attribute("A106"));
        fastVector.addElement(new Attribute("A107"));
        fastVector.addElement(new Attribute("A108"));
        fastVector.addElement(new Attribute("A109"));
        fastVector.addElement(new Attribute("A110"));
        fastVector.addElement(new Attribute("A111"));
        fastVector.addElement(new Attribute("A112"));
        fastVector.addElement(new Attribute("A113"));
        fastVector.addElement(new Attribute("A114"));
        fastVector.addElement(new Attribute("A115"));
        fastVector.addElement(new Attribute("A116"));
        fastVector.addElement(new Attribute("A117"));
        fastVector.addElement(new Attribute("A118"));
        fastVector.addElement(new Attribute("A119"));
        fastVector.addElement(new Attribute("A120"));
        fastVector.addElement(new Attribute("A121"));
        fastVector.addElement(new Attribute("A122"));
        fastVector.addElement(new Attribute("A123"));
        fastVector.addElement(new Attribute("A124"));
        fastVector.addElement(new Attribute("A125"));
        fastVector.addElement(new Attribute("A126"));
        fastVector.addElement(new Attribute("A127"));
        fastVector.addElement(new Attribute("A128"));
        fastVector.addElement(new Attribute("A129"));
        fastVector.addElement(new Attribute("A130"));
        fastVector.addElement(new Attribute("A131"));
        fastVector.addElement(new Attribute("A132"));
        fastVector.addElement(new Attribute("A133"));
        fastVector.addElement(new Attribute("A134"));
        fastVector.addElement(new Attribute("A135"));
        fastVector.addElement(new Attribute("A136"));
        fastVector.addElement(new Attribute("A137"));
        fastVector.addElement(new Attribute("A138"));
        fastVector.addElement(new Attribute("A139"));
        fastVector.addElement(new Attribute("A140"));
        fastVector.addElement(new Attribute("A141"));
        fastVector.addElement(new Attribute("A142"));
        fastVector.addElement(new Attribute("A143"));
        fastVector.addElement(new Attribute("A144"));
        fastVector.addElement(new Attribute("A145"));
        fastVector.addElement(new Attribute("A146"));
        fastVector.addElement(new Attribute("A147"));
        fastVector.addElement(new Attribute("A148"));
        fastVector.addElement(new Attribute("A149"));
        fastVector.addElement(new Attribute("A150"));
        fastVector.addElement(new Attribute("A151"));
        fastVector.addElement(new Attribute("A152"));
        fastVector.addElement(new Attribute("A153"));
        fastVector.addElement(new Attribute("A154"));
        fastVector.addElement(new Attribute("A155"));
        fastVector.addElement(new Attribute("A156"));
        fastVector.addElement(new Attribute("A157"));
        fastVector.addElement(new Attribute("A158"));
        fastVector.addElement(new Attribute("A159"));
        fastVector.addElement(new Attribute("A160"));
        fastVector.addElement(new Attribute("A161"));
        fastVector.addElement(new Attribute("A162"));
        fastVector.addElement(new Attribute("A163"));
        fastVector.addElement(new Attribute("A164"));
        fastVector.addElement(new Attribute("A165"));
        fastVector.addElement(new Attribute("A166"));
        fastVector.addElement(new Attribute("A167"));
        fastVector.addElement(new Attribute("A168"));
        fastVector.addElement(new Attribute("A169"));
        fastVector.addElement(new Attribute("A170"));
        fastVector.addElement(new Attribute("A171"));
        fastVector.addElement(new Attribute("A172"));
        fastVector.addElement(new Attribute("A173"));
        fastVector.addElement(new Attribute("A174"));
        fastVector.addElement(new Attribute("A175"));
        fastVector.addElement(new Attribute("A176"));
        fastVector.addElement(new Attribute("A177"));
        fastVector.addElement(new Attribute("A178"));
        fastVector.addElement(new Attribute("A179"));
        fastVector.addElement(new Attribute("A180"));
        fastVector.addElement(new Attribute("A181"));
        fastVector.addElement(new Attribute("A182"));
        fastVector.addElement(new Attribute("A183"));
        fastVector.addElement(new Attribute("A184"));
        fastVector.addElement(new Attribute("A185"));
        fastVector.addElement(new Attribute("A186"));
        fastVector.addElement(new Attribute("A187"));
        fastVector.addElement(new Attribute("A188"));
        fastVector.addElement(new Attribute("A189"));
        fastVector.addElement(new Attribute("A190"));
        fastVector.addElement(new Attribute("A191"));
        fastVector.addElement(new Attribute("A192"));
        fastVector.addElement(new Attribute("A193"));
        fastVector.addElement(new Attribute("A194"));
        fastVector.addElement(new Attribute("A195"));
        fastVector.addElement(new Attribute("A196"));
        fastVector.addElement(new Attribute("A197"));
        fastVector.addElement(new Attribute("A198"));
        fastVector.addElement(new Attribute("A199"));
        fastVector.addElement(new Attribute("A200"));
        fastVector.addElement(new Attribute("A201"));
        fastVector.addElement(new Attribute("A202"));
        fastVector.addElement(new Attribute("A203"));
        fastVector.addElement(new Attribute("A204"));
        fastVector.addElement(new Attribute("A205"));
        fastVector.addElement(new Attribute("A206"));
        fastVector.addElement(new Attribute("A207"));
        fastVector.addElement(new Attribute("A208"));
        fastVector.addElement(new Attribute("A209"));
        fastVector.addElement(new Attribute("A210"));

        fastVector.addElement(new Attribute("type0", getClassFastVector()));
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
        value[210] = getClassFastVector().indexOf("type0");//210
        if(instances.add(new DenseInstance(1.0,value))==false){
            System.out.println("use2创建实例失败");
        };
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
        fastVector.addElement("6 ");

        return fastVector;
    }

//    public Classifier getClassifier(String fileAddress) throws IOException, ClassNotFoundException {//进行model文件的读入，以及模型的返回
//        File sdfile = Environment.getExternalStorageDirectory();//内存地址
//        Classifier classifier = (Classifier) (new ObjectInputStream(new FileInputStream(new File(sdfile,fileAddress)))).readObject();//进行文件转化为模型
//
//        return classifier;
//    }
public Classifier getClassifier(InputStream path) throws IOException, ClassNotFoundException {
    Classifier classifier= (Classifier) (new ObjectInputStream(path)).readObject();
    return classifier;
}
}
