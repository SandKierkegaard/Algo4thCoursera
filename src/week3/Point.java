package week3;
import edu.princeton.cs.introcs.StdDraw;

/*************************************************************************
 * Name: Sandiego Rain
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;
public class Point implements Comparable<Point> {
    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Slope_Order();       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }
    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }
    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        if (this.x != that.x && this.y == that.y)  return 0.0;
        if (this.x == that.x && this.y != that.y) 
            return Double.POSITIVE_INFINITY;
        if (this.x == that.x && this.y == that.y)
            return Double.NEGATIVE_INFINITY;
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if ((this.y < that.y) || (this.y == that.y && this.x < that.x))
            return -1;
        else if (this.y == that.y && this.x == that.x)
            return 0;
        return 1; // neither 1st nor 2nd case.
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
    // THE Comparator: compare points by slope to this point
    private class Slope_Order implements Comparator<Point> {
        public int compare(Point p, Point q) {
            if (Point.this.slopeTo(p) < Point.this.slopeTo(q))
                return -1;
            else if (Point.this.slopeTo(p) == Point.this.slopeTo(q))
                return 0;
            return 1; //neither of above cases
        }
    }
    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}