package com.rjjhsys.ztegesturerecognition.mathUtil;
import java.util.ArrayList;

public class PeaksDetect {
    public static int getPeakNum(double[] data, double minPeak, int minDisNum) {
    	int peakNum = 0;
    	if (data.length>=7) {
        for (int k = 0; k < data.length; k++) {
            if (k==0) {
            }else if (k == 1 ) {
            	if (data[k] > data[k - 1] && data[k] > data[k + 1] && data[k + 1] > data[k + 2] && data[k + 2] > data[k + 3] && data[k] > minPeak) {
				peakNum++;
                k = k + minDisNum;

                }
            } else if (k == 2) {

                if ( data[k] > data[k - 1] && data[k] > data[k + 1] && data[k + 1] > data[k + 2] && data[k + 2] > data[k + 3] && data[k - 1] > data[k - 2] && data[k] > minPeak) {
            	peakNum++;
                k = k + minDisNum;

                }
           } else if (k == (data.length - 1) ) {

            }else if (k == (data.length - 2)  ) {
               if (data[k] > data[k - 1] && data[k] > data[k + 1] && data[k - 1] > data[k - 2] && data[k - 2] > data[k - 3] && data[k] > minPeak) {
				peakNum++;
                k = k + minDisNum;

             }   
            } else if ((k == data.length - 3)) {

            	 if (data[k] > data[k + 1] && data[k + 1] > data[k + 2] && data[k] > data[k - 1] && data[k - 1] > data[k - 2] && data[k - 2] > data[k - 3] && data[k] > minPeak) {
     				peakNum++;
                     k = k + minDisNum;

                  }	

            } else  {
                System.out.println(data[k-3]+"  "+data[k-2]+"  "+data[k-1]+"  "+data[k]+"  "+data[k+1]+"  "+data[k+2]+"  "+data[k+3]);
            	if ( data[k] > data[k + 1] &&data[k + 1] > data[k + 2] && data[k + 2] > data[k + 3] && data[k - 1] < data[k] && data[k - 2] < data[k - 1] && data[k - 3] < data[k - 2] && data[k] > minPeak) {

                    peakNum++;
                     k = k + minDisNum;

                  }	
            	
            }
        }
}else {
	System.out.println("data is too short!!!");
}
   return peakNum;
    }

    //list
    public static int getPeakNum(ArrayList data, double minPeak, int minDisNum) {
        int peakNum = 0;
        if (data.size()>=7) {
            for (int k = 0; k < data.size(); k++) {
                if (k==0) {

                }else if (k == 1 ) {
                    if ((double)data.get(k) > (double) data.get(k-1) && (double)data.get(k) > (double)data.get(k+1) && (double)data.get(k+1) > (double)data.get(k+2) && (double)data.get(k+2) > (double)data.get(k+3) && (double)data.get(k) > minPeak) {
                        peakNum++;
                        k = k + minDisNum;
                    }
                } else if (k == 2) {
                    if ( (double)data.get(k) > (double)data.get(k-1) && (double)data.get(k) > (double)data.get(k+1) && (double)data.get(k+1) > (double)data.get(k+2) && (double)data.get(k+2) > (double)data.get(k+3) && (double)data.get(k-1) > (double)data.get(k-2) && (double)data.get(k) > minPeak) {
                        peakNum++;
                        k = k + minDisNum;
                    }
                } else if (k == (data.size() - 1) ) {

                }else if (k == (data.size() - 2)  ) {
                    if ((double)data.get(k) > (double)data.get(k-1) && (double)data.get(k) > (double)data.get(k+1) && (double)data.get(k-1) > (double)data.get(k-2) && (double)data.get(k-2) > (double)data.get(k-3) && (double)data.get(k) > minPeak) {
                        peakNum++;
                        k = k + minDisNum;
                    }
                } else if ((k == data.size() - 3)) {

                    if ((double)data.get(k) > (double)data.get(k+1) && (double)data.get(k+1) > (double)data.get(k+2) && (double)data.get(k) > (double)data.get(k-1) && (double)data.get(k-1) > (double)data.get(k-2) && (double)data.get(k-2) > (double)data.get(k-3) && (double)data.get(k) > minPeak) {
                        peakNum++;
                        k = k + minDisNum;
                    }

                } else 
                	//if ((double)data.get(k) > (double)data.get(k+1)) {

                    if ( (double)data.get(k) > (double)data.get(k+1) &&(double)data.get(k+1) > (double)data.get(k+2) && (double)data.get(k+2) > (double)data.get(k+3) && (double)data.get(k-1) < (double)data.get(k) && (double)data.get(k-2) < (double)data.get(k-1) && (double)data.get(k-3) < (double)data.get(k-2) && (double)data.get(k) > minPeak) {
                        peakNum++;
                        k = k + minDisNum;
                    }

              //  }
            }
        }else {
            System.out.println("data is too short!!!");
        }
        return peakNum;
    }

    //三个端点检测
    public static int getPeakNumSimple(ArrayList data, double minPeak, int minDisNum) {
        int peakNum = 0;
        if (data.size()>=7) {
            for (int k = 0; k < data.size(); k++) {
                if (k==0) {

                } else if (k == (data.size() - 1) ) {


                } else
                    //if ((double)data.get(k) > (double)data.get(k+1)) {

                    if ( (double)data.get(k) > (double)data.get(k+1)  && (double)data.get(k-1) < (double)data.get(k) && (double)data.get(k) > minPeak) {
                        peakNum++;
                        k = k + minDisNum;
                    }

                //  }
            }
        }else {
            System.out.println("data is too short!!!");
        }
        return peakNum;
    }

}


