package chap1;
import java.io.*;
import java.io.FileInputStream;
import java.lang.System;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class TestMain {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("C://Users/SD/Desktop/tinyUF.txt")));
		
        int N = StdIn.readInt();
      WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
      while (!StdIn.isEmpty()) {

          int p = StdIn.readInt();
          int q = StdIn.readInt();
          if (uf.connected(p, q)) continue;
          uf.union(p, q);
          StdOut.println(p + " " + q);

      }
      StdOut.println(uf.count() + " components");
      StdOut.println(N);
//      while (!StdIn.isEmpty()) {
//          int p = StdIn.readInt();
//        int q = StdIn.readInt();
//        StdOut.println(p + " " + q);
//      }
      
        	StdOut.println("WTF???");
  }

}