package com.rjjhsys.ztegesturerecognition.mathUtil;



public class Entropy {

	public static double getEntropy2( long[][] k) {
        double h = 0d;
        double sum_k = 0d;
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                sum_k += (double) k[i][j];
            }
        }
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                if (k[i][j] != 0) {
                    final double p_ij = (double) k[i][j] / sum_k;
                    h += p_ij * Math.log(p_ij);
                }
            }
        }
        return -h;
    }

    /**
     * Calculates the <a href="http://en.wikipedia.org/wiki/Entropy_%28information_theory%29">
     * Shannon entropy</a> for a vector.  The values of {@code k} are taken to be
     * incidence counts of the values of a random variable. What is returned is <br/>
     * &sum;p<sub>i</sub>log(p<sub>i</sub><br/>
     * where p<sub>i</sub> = k[i] / (sum of elements in k)
     *
     * @param k Vector (for ex. Row Sums of a trials)
     * @return Shannon Entropy of the given Vector
     *
     */
    public static double getEntropy(double[] k) {
        double h = 0d;
        double sum_k = 0d;
        for (int i = 0; i < k.length; i++) {
            sum_k += (double) k[i];
        }
        for (int i = 0; i < k.length; i++) {
            if (k[i] != 0) {
                final double p_i = (double) k[i] / sum_k;
                h += p_i * Math.log(p_i);
            }
        }
        return -h;
    }
}
