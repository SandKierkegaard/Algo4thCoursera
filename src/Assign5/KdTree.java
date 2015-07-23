
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.lang.System;

public class KdTree {
    SET<Point2D> set;
    Node root;
    int sizeT = 0;
    boolean orienI = false;

    private static class Node {
        private Point2D p;
        private RectHV rect;
        private Node lb;
        private Node rt;
        public Node(Point2D pp, Node lbb, Node rtt) {
           p = pp;  lb = lbb; rt = rtt; 
        }

    }
    
/*    public KdTree() {
    } // construct an empty set of points
*/
    public boolean isEmpty() {
        return (sizeT == 0);
    } // is the set empty?

    public int size() {
        return sizeT;
    } // number of points in the set

    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("null P2D"); }
        orienI = false;
        root = insert(root, p, orienI);
    } // add the point to the set (if it is not already in the set)

    private Node insert(Node n, Point2D p, boolean orien) {
     if (n == null) {
        sizeT++; 
         return new Node (p, null, null); }
     if (orien) {
         //int cmp = Point2D.Y_ORDER.compare(p, n.p);
         double cmp = p.y() - n.p.y();
         if (cmp < 0) n.lb = insert(n.lb, p, !orien);
         else if (cmp >= 0) {
            //if (Point2D.X_ORDER.compare(p, n.p) != 0) 
             if (!((p.y() == n.p.y()) && (p.x() == n.p.x())))
             n.rt = insert(n.rt, p, !orien);
            //else   n.p = p;
        }
     }
     else if (!orien) {
         //int cmp = Point2D.X_ORDER.compare(p, n.p);
         double cmp = p.x() - n.p.x();
         if (cmp < 0) n.lb = insert(n.lb, p, !orien);
         else if (cmp >= 0) {
            //if (Point2D.Y_ORDER.compare(p, n.p) != 0) 
         //if (p.y() - n.p.y() != 0) 
             if (!((p.y() == n.p.y()) && (p.x() == n.p.x())))
             n.rt = insert(n.rt, p, !orien);
            //else   n.p = p;
       }
     } 
     return n;
    }
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("null P2D"); }
        return get(p) != null;
    } // does the set contain point p?

    public Point2D get(Point2D p) {
            return get(root, p, orienI);
        }
    public Point2D get(Node n, Point2D p, boolean orien) {
        if (n == null) return null;

      if (orien) {
         double cmp = p.y() - n.p.y();
         if (cmp < 0) return get(n.lb, p, !orien);
         else if (cmp >= 0) {
             if (!((p.y() == n.p.y()) && (p.x() == n.p.x())))
             return get(n.rt, p, !orien);
            else return  n.p;
        }
     }
     else if (!orien) {
         double cmp = p.x() - n.p.x();
         if (cmp < 0) return get(n.lb, p, !orien);
         else if (cmp >= 0) {
             if (!((p.y() == n.p.y()) && (p.x() == n.p.x())))
             return get(n.rt, p, !orien);
            else  return  n.p;
       }
     } 
        return null;
     }
    public void draw() {
            if (root != null)  {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.01);
            drawp(root);
            StdDraw.show(0);
            boolean orienD = false;
            drawl(root, orienD);  
            StdDraw.show(0); }
        
    } // draw all points to standard draw

    private void drawp(Node n) {
    n.p.draw();
    if (n.lb != null)
        drawp(n.lb);
    if (n.rt != null)
        drawp(n.rt);
    } // recursively draw all points

    private void drawl(Node n, boolean orien) {
    if (!orien)
        n.p.draw();
    if (n.lb != null)
        drawl(n.lb, !orien);
    if (n.rt != null)
        drawl(n.rt, !orien);
    } // recursively draw all lines

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
        Point2D theP = null ;
        double dis = p.distanceTo(set.min());
        for (Point2D setp : set) {
            if ((dis > 0.0) && (p.distanceTo(setp) < dis) ) { 
                dis = p.distanceTo(setp);
                theP = setp;    }
        }
        return theP;
    } // a nearest neighbor in the set to point p; null if the set is empty

    public static void main(String[] args) {
         String filename = args[0];
         In in = new In(filename);
        KdTree kdtree = new KdTree();
      while (!in.isEmpty()) {
          double x = in.readDouble();
          double y = in.readDouble();
          Point2D p = new Point2D(x, y);
          kdtree.insert(p);
      }
    Point2D testP = new Point2D(0.206107, 0.095492);
     StdOut.printf("Contains?? %b\n", kdtree.contains(testP));
     StdOut.printf("root?? %s\n", kdtree.root.p);
     StdOut.printf("C?? %s\n", kdtree.root.lb.p);
     StdOut.printf("I?? %s\n", kdtree.root.lb.rt.p);
     StdOut.printf("B?? %s\n", kdtree.root.rt.p);
     StdOut.printf("D?? %s\n", kdtree.root.rt.lb.p);
     StdOut.printf("E?? %s\n", kdtree.root.rt.rt.p);
     StdOut.printf("H?? %s\n", kdtree.root.rt.lb.lb.p);
     StdOut.printf("F?? %s\n", kdtree.root.rt.lb.rt.p);
     StdOut.printf("G?? %s\n", kdtree.root.rt.rt.lb.p);
     StdOut.printf("J?? %s\n", kdtree.root.rt.rt.lb.rt.p);
     StdOut.printf("size of tree is %d \n", kdtree.size());

    kdtree.draw();
    } // unit testing of the methods (optional)

}
