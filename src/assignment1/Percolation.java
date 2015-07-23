/*----------------------------------------------------------------
 *  Author:        Sandiego Rain
 *  Written:       7/20/2014
 *  
 *  Compilation:   javac Percolation.java
 *  Execution:     java Percolation
 *
 *----------------------------------------------------------------*/
package assignment1;
import java.io.*;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/*----------------------------------------------------------------
 *  Author:        Sandiego Rain
 *  Written:       7/20/2014
 *  
 *  Compilation:   javac Percolation.java
 *  Execution:     java Percolation
 *
 *----------------------------------------------------------------*/

public class Percolation {
    private int sizeN = 1;  //grid width N , equivalent to WeightedUF.count()
    private boolean[][] grid;
    private WeightedQuickUnionUF UF;
    private boolean[] connectedToBottom;
    
    /**
     * create N-by-N grid, with all sites blocked
     */
    public Percolation(int N)  {
        if (N <= 0)
            throw new IllegalArgumentException("N <=0");
        sizeN = N;
        grid = new boolean[N+1][N+1];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                grid[i][j] = false; // false = blocked, true = open
            }
        }
        UF = new WeightedQuickUnionUF(N*N + 1);
        connectedToBottom = new boolean[N*N+1];
        for (int k = 0; k < N*N+1; k++)
            connectedToBottom[k] = false;
    }
    /**
     * use union()
     * open site (row i, column j) if it is not already
     */
    public void open(int i, int j) {
        validate(i, j);
        if (!grid[i][j])
            grid[i][j] = true;  // open it
        if (i == 1) { 
            //index sizeN*sizeN+1-1 of UF is the top virtual site
            UF.union(xy1D(i, j), sizeN*sizeN); 
        //    if (sizeN == 1) 
        //        connectedToBottom[UF.find(xy1D(i, j))] = true; }
        }
        if (i == sizeN)
                connectedToBottom[UF.find(xy1D(i, j))] = true; 

        if (i > 1 && isOpen(i-1, j)) {
            if (i == sizeN) {
        //        connectedToBottom[UF.find(xy1D(i, j))] = true;
                connectedToBottom[UF.find(xy1D(i-1, j))] = true; }
            if (connectedToBottom[UF.find(xy1D(i-1, j))])
                connectedToBottom[UF.find(xy1D(i, j))] = true;
            UF.union(xy1D(i, j), xy1D(i-1, j));
            
        }
        if (i < sizeN && isOpen(i+1, j)) {
            if (i == sizeN-1)  // just hooked up w/ an open bottom site
                connectedToBottom[UF.find(xy1D(i, j))] = true;
            if (connectedToBottom[UF.find(xy1D(i+1, j))])
                connectedToBottom[UF.find(xy1D(i, j))] = true;
            UF.union(xy1D(i, j), xy1D(i+1, j));
            
        }
        if (j > 1 && isOpen(i, j-1)) {
            if (connectedToBottom[UF.find(xy1D(i, j-1))])
                connectedToBottom[UF.find(xy1D(i, j))] = true;
            UF.union(xy1D(i, j), xy1D(i, j-1));
        }
        if (j < sizeN && isOpen(i, j+1)) {
            if (connectedToBottom[UF.find(xy1D(i, j+1))])
                connectedToBottom[UF.find(xy1D(i, j))] = true;    
            UF.union(xy1D(i, j), xy1D(i, j+1));
        }
    }
    /**
     * use connected()
     * is site (row i, column j) open?
     */
    public boolean isOpen(int i, int j) {
        validate(i, j);
        return grid[i][j];
    }
    /**
     * use connected()
     * is site (row i, column j) full?
     */
    public boolean isFull(int i, int j) {
        validate(i, j);
        return UF.connected(xy1D(i, j), sizeN*sizeN);
    }
    /**
     * use connected() from WQUUF
     * does the system percolate?
     */
    public boolean percolates() {
        return connectedToBottom[UF.find(sizeN*sizeN)];
    }
    
    private int xy1D(int a, int b) {
        return (a-1) *sizeN + b -1;
    }
    
    private void validate(int i, int j) {
        // grid[N+1][N+1] and the extra row/column is not used
        if (i <= 0 || i > sizeN) throw 
            new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > sizeN) throw 
            new IndexOutOfBoundsException("column index j out of bounds");
    }
    
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(args[0]);
        Percolation pC = new Percolation(N);
        pC.open(1, 1);
        pC.open(2, 1);
        System.out.println(pC.UF.connected(0, 3));
        pC.open(2, 2);
        pC.open(3, 2);
        System.out.println(pC.percolates());
        System.out.println(pC.UF.connected(0, 7));
    } 
}
