package com.rjjhsys.ztegesturerecognition.DTWUtils;

/**
 * Created by gongyan on 2017/6/7.
 */





public class DTW {
    static int DTWMAXNUM = 400000;
    static int DTWMAXNUM2 = 500000;
    static double[][] dtwpath = new double[400][400];
    static double[][] distance = new double[400][400];
    public DTW() {
    }

    public static double getDtwDistance(double A[], int I, double B[], int J,
                                        int r) {

        int i, j;
        double dist;
        int istart, imax;
        int r2 = r + Math.abs(I - J);
        double g1;
        double g2;
        double g3;
        int pathsig = 1;
        if (I > 400 || J > 400) {

            System.out.println("Too big number\n" +
                    "I:"+I+"J:"+J);
            return -1;
        }

        for (i = 0; i < I; i++) {
            for (j = 0; j < J; j++) {
                dtwpath[i][j] = 0;
                distance[i][j] = DTWMAXNUM2;


            }
        }
        distance[0][0] = (double) 2 * Math.abs(A[0]
                - B[0]);
        for (i = 1; i <= r2 && i < I; i++) {
            distance[i][0] = distance[i - 1][0] + Math.abs(A[i] - B[0]);
        }
        for (j = 1; j <= r2 && j < J; j++) {
            distance[0][j] = distance[0][j - 1] + Math.abs(A[0] - B[j]);
        }

        for (j = 1; j < J; j++) {
            istart = j - r2;
            if (j <= r2)
                istart = 1;
            imax = j + r2;
            if (imax >= I)
                imax = I - 1;

            for (i = istart; i <= imax; i++) {
                g1 = distance[i - 1][j] + Math.abs(A[i] - B[j]);
                g2 = distance[i - 1][j - 1] + 2 * Math.abs(A[i] - B[j]);
                g3 = distance[i][j - 1] + Math.abs(A[i] - B[j]);
                g2 = Math.min(g1, g2);
                g3 = Math.min(g2, g3);
                distance[i][j] = g3;
            }
        }

        dist = distance[I - 1][J - 1];// /((double)(I+J));
        return dist;
    }/* end DTWDistance */
    public static double DTWDistanceFun(double A[][], int I, double B[][], int J,
                                        int r,int se) {
        int i, j;
        double dist;
        int istart, imax;
        int r2 = r + Math.abs(I - J);
        double g1;
        double g2;
        double g3;
        int pathsig = 1;
        if (I > 400 || J > 400) {
            System.out.println("Too big number\n");
            return -1;
        }
        for (i = 0; i < I; i++) {
            for (j = 0; j < J; j++) {
                dtwpath[i][j] = 0;
                distance[i][j] = DTWMAXNUM2;
            }
        }


        distance[0][0] = (double) 2 * Math.abs(A[0][se]
                - B[0][se]);
        for (i = 1; i <= r2 && i < I; i++) {
            distance[i][0] = distance[i - 1][0] + Math.abs(A[i][se] - B[0][se]);
        }
        for (j = 1; j <= r2 && j < J; j++) {
            distance[0][j] = distance[0][j - 1] + Math.abs(A[0][se] - B[j][se]);
        }

        for (j = 1; j < J; j++) {
            istart = j - r2;
            if (j <= r2)
                istart = 1;
            imax = j + r2;
            if (imax >= I)
                imax = I - 1;

            for (i = istart; i <= imax; i++) {
                g1 = distance[i - 1][j] + Math.abs(A[i][se] - B[j][se]);
                g2 = distance[i - 1][j - 1] + 2 * Math.abs(A[i][se] - B[j][se]);
                g3 = distance[i][j - 1] + Math.abs(A[i][se] - B[j][se]);
                g2 = Math.min(g1, g2);
                g3 = Math.min(g2, g3);
                distance[i][j] = g3;
            }
        }

        dist = distance[I - 1][J - 1];//
        return dist;
    }

}