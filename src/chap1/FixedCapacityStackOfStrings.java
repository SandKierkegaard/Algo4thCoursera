package chap1;


import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] a;  // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public boolean isEmpty()            {  return (N == 0);                  }
    public boolean isFull()             {  return (N == a.length);           }
    public void push(String item)       {  a[N++] = item;                    }
    public String pop()                 {  return a[--N];                    }
    public String peek()                {  return a[N-1];                    }
    public Iterator<String> iterator()  { return new ReverseArrayIterator(); }


    public class ReverseArrayIterator implements Iterator<String> {
        private int i = N-1;

        public boolean hasNext() { return i >= 0; }
        public String next()     { return a[i--]; }
        public void remove()      { throw new UnsupportedOperationException(); }
    }


    public static void main(String[] args) throws Exception {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);
        System.setIn(new FileInputStream(new File("F://Libraries/Desktop/TestInput/stackString.txt")));
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item); 
            else if (stack.isEmpty())  StdOut.println("BAD INPUT"); 
            else                       StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    } 
} 