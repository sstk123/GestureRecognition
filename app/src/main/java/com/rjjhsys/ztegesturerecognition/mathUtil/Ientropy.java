package com.rjjhsys.ztegesturerecognition.mathUtil;



public class Ientropy {

	public static double getEntropy(double[] data,int binNum) {
		
		//����bin�ĸ���
		double[] localBin = new double[binNum+1];
		int[] localNum = new int[binNum];
		double[] localProbabilities = new double[binNum];
		double[] logProbabilities = new double[binNum];
		double e =0;

		double max = MaxNum.getMaxNum(data);
		double min = MinNum.getMinNum(data);
		localBin[0] = min-0.00000001;
		localBin[binNum] = max+0.0000001;
		for(int i=1;i<localBin.length-1;i++){
			localBin[i] = min + (max-min)/binNum*i;
					}

		for(int i=0;i<data.length;i++)
		{
			for (int j = 0; j < localBin.length-1; j++) {
				if (data[i]>=localBin[j]&&data[i]<localBin[j+1]) {
				localNum[j]++;
				j = localNum.length;
				
			}  
			}
			
		}
		
//		for (int i = 0; i < localNum.length; i++) {
//			System.out.println(localNum[i]);
//		}
//		
		for(int i = 0; i < localNum.length; i++){
			//
			localProbabilities[i] = (double)localNum[i]/data.length;
			if (localProbabilities[i]!=0.0) {
				logProbabilities[i] = - Math.log((double)localProbabilities[i])/Math.log((double)2);
			}else {
				logProbabilities[i] = 0;
			}
			
		}
		for (int j = 0; j < logProbabilities.length; j++) {
				e+=localProbabilities[j]*logProbabilities[j];
			}
		return e;
		
	}
	
	}
