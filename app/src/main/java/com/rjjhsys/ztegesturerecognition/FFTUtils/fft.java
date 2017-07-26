package com.rjjhsys.ztegesturerecognition.FFTUtils;

public class fft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] a = {1,1,1,1,1,11,1,1,1,11,3,6,2,3,1,1,1,11,1,1,1,1,1,1,1,12,22,5,2,54,2,4,52,5,5,2,54,4,12,2,5,1};
	Complex[] result = Dft.directDft(a);
	for (int i = 0; i < result.length; i++) {
		System.out.println(result[i].re());
	}
	}

}
