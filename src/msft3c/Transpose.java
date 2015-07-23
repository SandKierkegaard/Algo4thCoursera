package msft3c;

import java.util.*;
import java.lang.*;
import java.io.*;

class Transpose {

    public static long tailR(long n) {
        if (n <= 2)
            return 1;
        else
        return tailRHelp(0, 1, n);
    }
    public static long tailRHelp( long a, long b, long count) {
        if ( count < 0)
            return a;
        
        return tailRHelp(b, b+a, count-1);
    }

    public static void main(String[] args) {
        Transpose t = new Transpose();
        System.out.println(t.tailR(4));
    }
}