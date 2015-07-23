//package week3;
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.Arrays;
//
//import edu.princeton.cs.introcs.StdDraw;
//import edu.princeton.cs.introcs.StdOut;
//
//import java.lang.System;
//
//import edu.princeton.cs.introcs.StdIn;
//
//import java.util.Comparator;
//
//import week3.Point.Slope_Order;
//public class Faster {
//    public final Comparator<Point> SLOPE_ORDER = new Slope_Order();       // YOUR DEFINITION HERE
//    public static void main(String[] args) throws Exception {
//        StdDraw.setXscale(0, 32768);
//        StdDraw.setYscale(0, 32768);
//        StdDraw.show(0);
//        StdDraw.setPenRadius(0.01);  // make the points a bit larger
//        
//        //System.setIn(new FileInputStream(new File(args[0])));
//        System.setIn(new FileInputStream(new File("C://Users/SD/Desktop/TestInput/collinear/input8.txt")));
//        int N = StdIn.readInt(); // num of points
//        Point[] points = new Point[N];
//        
//        for (int i = 0; i < N; i++) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            points[i] = new Point(p, q);
//            points[i].draw();
//        }
//        // display to screen all at once
//        StdDraw.show(0);
//        // reset the pen radius
//        StdDraw.setPenRadius();
//       // sort the array in natural order
//        Arrays.sort(points);
//
//        Point[] aux = new Point[N]; // copy the points into aux array
//        
//        for (int i = 0; i < N - 3; i++) {
//            for (int j = 0; j < N; j++) {
//                aux[j] = points[j];
//            }
//            Arrays.sort(aux, 0, N, points[i].SLOPE_ORDER);
//            StringBuilder sb = new StringBuilder(points[i].toString());
//            int k = 0;
//            if (points[i].compareTo(aux[k]) == 0) 
//                k++;
//            sb.append(" -> " + aux[k]); 
//         // counter: print&draw if at least 4 points are collinear
//            int atLeast4 = 2;   
//            while (k < N) {
//                if (points[i].compareTo(aux[k]) == 0) {
//                    k++; continue;
//                }
//                if ( k < N -1 && (points[i].slopeTo(aux[k]) == points[i].slopeTo(aux[k + 1]))) {
//                    sb.append(" -> " + aux[k + 1]);
//                    atLeast4++;
//                }
//                else {
//                    int startInd = k - (atLeast4 - 2); 
//             // atLeast 4 pts collinear & avoid printing subset of longer set
//                    if (atLeast4 >= 4 && (points[i].compareTo(aux[startInd]) > 0)) {
//                        String result = sb.toString();
//                        StdOut.println(result);
//                        points[i].drawTo(aux[k]);
//                    }
//                    sb = new StringBuilder(points[i].toString());
//                    sb.append(" -> " + aux[k]);
//                    atLeast4 = 2; // reset the counter
//                    }
//                k++;
//            }
//
//        }
//        
//        // display to screen all at once
//        StdDraw.show(0);
//        // reset the pen radius
//        StdDraw.setPenRadius();
//    }
//    private static void merge(Object [] a, Object [] aux, int lo, int mid, int hi, Comparator comp) {
//
//        // copy to aux[]
//        for (int k = lo; k <= hi; k++) {
//            aux[k] = a[k]; 
//        }
//
//        // merge back to a[]
//        int i = lo, j = mid+1;
//        for (int k = lo; k <= hi; k++) {
//            if      (i > mid)              a[k] = aux[j++];   // this copying is unnecessary
//            else if (j > hi)               a[k] = aux[i++];
//            else if (less(comp, aux[j], aux[i])) a[k] = aux[j++];
//            else                           a[k] = aux[i++];
//        }
//
//    }
//
//    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
//    private static void sort(Object [] a, Object [] aux, int lo, int hi, Comparator comp) {
//        if (hi <= lo) return;
//        int mid = lo + (hi - lo) / 2;
//        sort(a, aux, lo, mid, comp);
//        sort(a, aux, mid + 1, hi, comp);
//        merge(a, aux, lo, mid, hi, comp);
//    }
//
//    /**
//     * Rearranges the array in ascending order, using the natural order.
//     * @param a the array to be sorted
//     */
//    public static void sort(Object [] a, Comparator comp) {
//        Object [] aux = new Object [a.length];
//        sort(a, aux, 0, a.length-1, comp);
//    }
//
//    // is v < w ?
//    private static boolean less(Comparator c, Object v, Object  w) {
//        return (c.compare(v, w) < 0);
//    }
//}
