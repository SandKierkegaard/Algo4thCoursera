package week3;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import edu.princeton.cs.introcs.StdDraw;
import java.lang.System;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Brute {

    public static void main(String[] args) throws Exception {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger
        
        //System.setIn(new FileInputStream(new File(args[0])));
        System.setIn(new FileInputStream(new File("F://Libraries/Desktop/TestInput/collinear/input56.txt")));
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
        
        for (int a = 0; a < N; a++) {
         for (int b = a + 1; b < N; b++) {
          for (int c = b + 1; c < N ; c++) {
           for (int d = c + 1; d < N; d++) {
               if (points[a].slopeTo(points[b]) == points[a].slopeTo(points[c])) {
                   if (points[a].slopeTo(points[b]) == points[a].slopeTo(points[d])) {
                       points[a].drawTo(points[d]);
                       StdOut.println(points[a] + " -> " + points[b] + " -> "
                               + points[c] + " -> " + points[d]);
                   }
                   else continue;
               }
                   
           }
          }
         }
        }
        // display to screen all at once
        StdDraw.show(0);
        // reset the pen radius
        StdDraw.setPenRadius();
    }
}
