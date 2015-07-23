/*----------------------------------------------------------------
 *  Author:        Sandiego Rain
 *  Written:       7/20/2014
 *  
 *  Compilation:   javac PercolationStats.java
 *  Execution:     java PercolationStats N T
 *
 *
 *  % java PercolationStats 200 100
 *  mean                    = 0.5929934999999997
 *  stddev                  = 0.00876990421552567
 *  95% confidence interval = 0.5912745987737567, 0.5947124012262428
 *
 *----------------------------------------------------------------*/
package assignment1;

import java.io.File;
import java.io.FileInputStream;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
/*----------------------------------------------------------------
 *  Author:        Sandiego Rain
 *  Written:       7/20/2014
 *  
 *  Compilation:   javac PercolationStats.java
 *  Execution:     java PercolationStats N T
 *
 *
 *  % java PercolationStats 200 100
 *  mean                    = 0.5929934999999997
 *  stddev                  = 0.00876990421552567
 *  95% confidence interval = 0.5912745987737567, 0.5947124012262428
 *
 *----------------------------------------------------------------*/
//package assignment1;

//import java.io.File;
//import java.io.FileInputStream;

//import edu.princeton.cs.introcs.StdRandom;
//import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private int thisT = 1;
    private double[] thres;    // thres array
    
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException("N<=0 || T<=0");
        thisT = T;
        this.thres = new double[T];
        for (int t = 0; t < T; t++) {
            int total = 0;
            Percolation perco = new Percolation(N);
            while (!perco.percolates()) {
                    int i = (int) StdRandom.uniform(1, N+1);
                    int j = (int) StdRandom.uniform(1, N+1);
                   if (!perco.isOpen(i, j)) {
                    perco.open(i, j);
                    total += 1; }
            }
        this.thres[t] = (double) total/ (double) (N*N);
        }
    }    
    public double mean() {
        return (double) StdStats.mean(this.thres);
    }                     // sample mean of percolation threshold
    public double stddev() {
        if (thisT == 1)
            return Double.NaN;
        return (double) StdStats.stddev(this.thres);
    }                  // sample standard deviation of percolation threshold
    public double confidenceLo() {
        return mean() - 1.96*stddev()/Math.sqrt(thisT);
    }             // returns lower bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96*stddev()/Math.sqrt(thisT);
    }             // returns upper bound of the 95% confidence interval
   
    
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats pS = new PercolationStats(N, T);

        
        System.out.println(
                "mean                        =" + pS.mean());
        System.out.println(
                "stddev                      =" + pS.stddev());
        System.out.println(
                "95% confidence interval     ="
                 + pS.confidenceLo() + ", " + pS.confidenceHi());
    }   
}
