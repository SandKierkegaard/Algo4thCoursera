package week2;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Subset {
    public static void main(String[] args) {
        RandomizedQueue<String> rQ = new RandomizedQueue<String>();
        int k =  Integer.parseInt(args[0]);
        int cnter = 0;
        
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (cnter >= k) {
                rQ.dequeue();
                }
            rQ.enqueue(item);
            cnter++;
            }
        for(String s : rQ)
            StdOut.println(s);
        }
    }

