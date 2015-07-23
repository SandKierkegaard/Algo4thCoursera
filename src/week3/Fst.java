package week3;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Iterator;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

import java.lang.System;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.algs4.SET;

public class Fst {

    public static void main(String[] args) throws Exception {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger
        
        //System.setIn(new FileInputStream(new File(args[0])));
        System.setIn(new FileInputStream(new File("C://Users/SD/Desktop/TestInput/collinear/rs1423.txt")));
        int N = StdIn.readInt(); // num of points
        Point[] points = new Point[N];
        
        for (int i = 0; i < N; i++) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            points[i] = new Point(p, q);
            points[i].draw();
        }
        // display to screen all at once
        StdDraw.show(0);
        // reset the pen radius
        StdDraw.setPenRadius();
       // sort the array in natural order
        Arrays.sort(points);

        Point[] aux = new Point[N]; // copy the points into aux array
        
        for (int i = 0; i < N - 3; i++) {
            for (int j = 0; j < N; j++) {
                aux[j] = points[j];
            }
            Arrays.sort(aux, 0 , N, points[i].SLOPE_ORDER);
            StringBuilder sb = new StringBuilder(points[i].toString());
            int k = 0;
//            if (points[i].compareTo(aux[k]) == 0) 
//                k++;
//            sb.append(" -> " + aux[k]); 
            SET<Point> sP = new SET<Point>();
//            sP.add(points[i]);
            sP.add(aux[k]);
         // counter: print&draw if at least 4 points are collinear
        //    int atLeast4 = 2;   
            while (k < N) {
//                if (points[i].compareTo(aux[k]) == 0 && points[i].compareTo(aux[k + 1]) < 0) {
//                    sb = new StringBuilder(points[i].toString());
//                    sb.append(" -> " + aux[k + 1]);
////                    atLeast4 = 2; // reset the counter                     
//                    k++; 
//                    StdOut.println("WTF " + points[i] + " " + aux[k]);
//                    continue;
//                }
                if ((k < N -1) && (points[i].slopeTo(aux[k]) == points[i].slopeTo(aux[k + 1]))) {
                    sP.add(aux[k + 1]);
//                    atLeast4++;
                }
                else {
//                    int startInd = k - (atLeast4 - 2); 
             // atLeast 4 pts collinear & avoid printing subset of longer set
//                    if (atLeast4 >= 4) {// && (points[i].compareTo(aux[startInd]) > 0)) {
                    if (sP.size() >= 3 && (points[i].compareTo(sP.min()) < 0)) {
                        Iterator<Point> it = sP.iterator();
//                        it.next();
                        while(it.hasNext())
                            sb.append(" -> " + it.next());
                        
                        String result = sb.toString();
                        StdOut.println(result);
//                        points[i].drawTo(aux[k]);
                        points[i].drawTo(sP.max());
                    }
                    if (k < N - 1 ) {
                    sb = new StringBuilder(points[i].toString());
                    sP = new SET<Point>();
//                    sP.add(points[i]);
                    sP.add(aux[k + 1]);
                } }
                k++;
            }

        }
        
        // display to screen all at once
        StdDraw.show(0);
        // reset the pen radius
        StdDraw.setPenRadius();
    }
}
