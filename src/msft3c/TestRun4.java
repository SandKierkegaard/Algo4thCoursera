package msft3c;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.File;
import java.io.FileInputStream;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import java.lang.System;
import java.util.Comparator;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.MinPQ;

class TestRun4 { // hashmap/ treemap tests

    public void printTimes(int[] array) {

        if (array == null)
            return;
        TreeMap<Integer, Integer> hs = new TreeMap<>();  
        // or HashMap for unordered
        for (int i = 0; i < array.length; i++) {
            if (!hs.containsKey(array[i])) {
                hs.put(array[i], 1);

            } else {
                hs.put(array[i], hs.get(array[i]) + 1);
            }
        }
        for (Integer e : hs.keySet()) {
            int times = hs.get(e);
            System.out.println(e + ":" + times);
        }

    }

    public static String rev(String s) {
        char[] chars = s.toCharArray();
        int len = s.length(), last = len - 1;

        for (int i = 0; i < len/2; i++) {
            char tmp = chars[i];
            chars[i] = chars[last - i];
            chars[last - i] = tmp;
        }

        return new String(chars);
    }
    
    public String formatRGB ( int r, int g, int b ) {
        return String.format ( "%02X%02X%02X", r, g, b );
    }

    public static void main(String[] args) throws Exception {

        int[] anArray = { 100, 200, 300, 400, 500, 600, 700, 300, 500, 600,
                800, 900, 1000 };
        TestRun4 tR = new TestRun4();
        tR.printTimes(anArray);
        
        System.out.println(tR.rev("Let me work."));
        System.out.println(tR.formatRGB(255, 0, 128));
    } // main
}
