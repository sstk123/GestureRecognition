package com.rjjhsys.ztegesturerecognition.mathUtil;

import java.util.ArrayList;

public class RMS {
	
	  public static double getRMS(ArrayList arrayList){

	        double temp = 0;
	        for(int i=0;i<arrayList.size();i++){
	        	
	        	temp += ((double) arrayList.get(i))*((double) arrayList.get(i));
	        }

	        return Math.sqrt(temp/(arrayList.size()));
			
	    }
	    public static double getRMS(double[] array){


	        double temp = 0;
	        for(int i=0;i<array.length;i++) {

	            temp += ((double) array[i])*((double) array[i]);
	        }
	        return Math.sqrt(temp/(array.length));
	    }

}
