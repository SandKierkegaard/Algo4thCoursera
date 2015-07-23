package week3;
import java.io.File;
import java.io.FileInputStream;

import edu.princeton.cs.introcs.StdDraw;


import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
/*************************************************************************
 *  Compilation:  javac PointPlotter.java
 *  Execution:    java PointPlotter input.txt
 *  Dependencies: Point.java, In.java, StdDraw.java
 *
 *  Takes the name of a file as a command-line argument.
 *  Reads in an integer N followed by N pairs of points (x, y)
 *  with coordinates between 0 and 32,767, and plots them using
 *  standard drawing.
 *
 *************************************************************************/

public class PointPlotter {
    public static void main(String[] args) throws Exception {

        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger

        // read in the input
//        String filename = args[0];
        
        System.setIn(new FileInputStream(new File("F://Libraries/Desktop/TestInput/collinear/input50.txt")));
        int N = StdIn.readInt(); // num of points
        
//        In in = new In(filename);
//        int N = in.readInt();
        for (int i = 0; i < N; i++) {
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            Point p = new Point(x, y);
            p.draw();
        }

        // display to screen all at once
        StdDraw.show(0);

        // reset the pen radius
        StdDraw.setPenRadius();
    }
}