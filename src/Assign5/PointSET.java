
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.lang.System;

public class PointSET {
    SET<Point2D> set;

    public PointSET() {
        set = new SET<Point2D>();
    } // construct an empty set of points

    public boolean isEmpty() {
        return set.isEmpty();
    } // is the set empty?

    public int size() {
        return set.size();
    } // number of points in the set

    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("null P2D"); }
        set.add(p);
    } // add the point to the set (if it is not already in the set)

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("null P2D"); }
        return set.contains(p);
    } // does the set contain point p?

    public void draw() {
        for (Point2D p : set) {
            p.draw();
        }
    } // draw all points to standard draw

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException("null rect"); }
        SET<Point2D> rset = new SET<Point2D>();
        for (Point2D p : set) {
            if (rect.contains(p) )
                    rset.add(p);
        }
        return rset;
    } // all points that are inside the rectangle

    public Point2D nearest(Point2D p) {
     double  dis = 0.0;
     Point2D theP = null;
     if (!set.isEmpty()) {
        theP = set.min() ;
            dis = p.distanceTo(set.min()); }
        for (Point2D setp : set) {
            if ( (p.distanceTo(setp) < dis) ) { 
                dis = p.distanceTo(setp);
                theP = setp;    }
        }
        return theP;
    } // a nearest neighbor in the set to point p; null if the set is empty

    public static void main(String[] args) {
    } // unit testing of the methods (optional)

}
