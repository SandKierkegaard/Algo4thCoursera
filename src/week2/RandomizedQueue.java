/*----------------------------------------------------------------
 *  Author:        Sandiego Rain
 *  Written:       8/1/2014
 *  
 *  Compilation:   javac RandomizedQueue.java
 *  Execution:     java RandomizedQueue
 *
 *
 *
 *----------------------------------------------------------------*/
package week2;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.FileInputStream;
import java.lang.System;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int N = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        q = (Item[]) new Object[2];
        N = 0;
    }
    // is the queue empty?
    public boolean isEmpty() {
        return (N == 0) ;
    }
    // return the number of items on the queue
    public int size() {
        return N;
    }
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++ ) {
            temp[i] = q[i];
        }
        q = temp;
    }
    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        if (N == q.length) resize(2*q.length);
        q[N++] = item;
    }
    // delete and return a random item
    public Item dequeue()         {
        if (isEmpty()) throw new NoSuchElementException("rQ underflow");
        int rnd = (int) StdRandom.uniform(1, N + 1);
        Item item = q[rnd - 1];
        q[rnd - 1] = q[N - 1];
        q[N - 1] = null;
        N--;
        if (N > 0 && N == q.length/4) resize(q.length/2);
        return item;
    }
    // return (but do not delete) a random item
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("rQ underflow");
        int rnd = (int) StdRandom.uniform(1, N + 1);
        Item item = q[rnd - 1];
        return item;
    }  

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        private Item[] iQ;
        public ReverseArrayIterator() {
            i = N;
            iQ = (Item[]) new Object[N];
            for (int j = 0; j < N; j++) {
                iQ[j] = q[j];
            }
        }
        public boolean hasNext() {
            return i > 0;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("iterator.next() exception");
            return iQ[--i];
        }
    }
    
     // unit testing
    public static void main(String[] args) {
        RandomizedQueue<String> rQ = new RandomizedQueue<>();
        
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) rQ.enqueue(item);
            else if (!rQ.isEmpty()) StdOut.print(rQ.dequeue() + " ");
        }
    }  
 }
