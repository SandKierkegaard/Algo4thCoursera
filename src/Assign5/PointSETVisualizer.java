/*************************************************************************
 *  Compilation:  javac PointSETVisualizer.java
 *  Execution:    java PointSETVisualizer
 *  Dependencies: StdDraw.java Point2D.java PointSET.java
 *
 *  Add the points that the user clicks in the standard draw window
 *  to a kd-tree and draw the resulting kd-tree.
 *
 *************************************************************************/

public class PointSETVisualizer {

    public static void main(String[] args) {
        RectHV rect = new RectHV(0.0, 0.0, 1.0, 1.0);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.02);
        PointSET kdtree = new PointSET();
        while (true) {
            if (StdDraw.mousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                System.out.printf("%8.6f %8.6f\n", x, y);
                Point2D p = new Point2D(x, y);
                if (rect.contains(p)) {
                    StdOut.printf("%8.6f %8.6f\n", x, y);
                    kdtree.insert(p);
                    StdOut.printf("%d\n", kdtree.size());
                    StdDraw.clear();
                    kdtree.draw();
                }
            }
            StdDraw.show(50);
        }

    }
}
