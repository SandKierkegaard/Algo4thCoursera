/*----------------------------------------------------------------
 *  Author:        Sandiego Rain
 *  Written:       8/1/2014
 *  
 *  Compilation:   javac Deque.java
 *  Execution:     java Deque
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

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node<Item> first;   //head sentinel
    private Node<Item> last;    //tail sentinel
    
    private static class Node<Item> {
        public Node( Item it, Node<Item> p, Node<Item> n) {
            item = it;
            prev = p;
            next = n;
        };
        public Item item;
        public Node<Item> next;
        public Node<Item> prev;
    }
    // construct an empty deque
    public Deque() {
        first = new Node<Item> (null, null, null);
        last = new Node<Item> (null, first, null);
        first.next = last;

        N = 0;
    }
    // is the deque empty?
    public boolean isEmpty() {
        return (N==0);
    }                 
    // return the number of items on the deque
    public int size() {
        return N;
    }              
    // insert the item at the front
    public void addFirst(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        Node<Item> newNode = new Node<Item> (item, first, first.next);
        first.next.prev = newNode;
        first.next = newNode;
        N++;
    }
    // insert the item at the end
    public void addLast(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        Node<Item> newNode = new Node<Item> (item, last.prev, last);
        last.prev.next = newNode;
        last.prev  = newNode;
        N++;
    }
    // delete and return the item at the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("dQ underflow");
        Item item = first.next.item;
        first.next.next.prev = first;
        first.next = first.next.next;
        N--;
        return item;
    } 
    // delete and return the item at the end
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("dQ underflow");
        Item item = last.prev.item;
       last.prev.prev.next = last;
       last.prev = last.prev.prev;
       N--;
       return item;
    } 
    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current =  (Node<Item>) first.next;
        }

        public boolean hasNext()  { return current != last;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    // unit testing
    public static void main(String[] args) {
    Deque<Integer> dq = new Deque<>();
    for (int i = 0; i < 10; i++) {
        dq.addFirst(i);
    }
//    for (int j = 0; j<10; j++) {
//        System.out.print(dq.removeFirst() + " ");
//    }
    for ( Integer i : dq ) {
        System.out.print( i + " ");
    }
    
    }   
 }