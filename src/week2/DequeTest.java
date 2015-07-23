package week2;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class DequeTest {
    @Test

    public void test001() {

        RandomizedQueue<String> rq = new RandomizedQueue();

        assertEquals(0, rq.size());

    }



    @Test (expected = NullPointerException.class)

    public void test002() {

        RandomizedQueue rq = new RandomizedQueue();

        rq.enqueue(null);        

    }

    

    @Test (expected = NoSuchElementException.class)

    public void test003() {

        RandomizedQueue rq = new RandomizedQueue();

        rq.dequeue();        

    }



    @Test (expected = NoSuchElementException.class)

    public void test004() {

        RandomizedQueue rq = new RandomizedQueue();

        rq.sample();        

    }



    @Test

    public void test005() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 1);

        assertEquals(1, rq.size());

    }

    

    @Test

    public void test006() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 10);

        assertEquals(10, rq.size());

    }

    

    @Test

    public void test007() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 50);

        assertEquals(50, rq.size());

    }



    @Test

    public void test008() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 100);

        assertEquals(100, rq.size());

    }



    @Test

    public void test009() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 1000);

        assertEquals(1000, rq.size());

    }



    @Test

    public void test010() {

        // test size for 10000 queues, enqueueing 1 to 10000

        for (int i = 1; i < 10000; i++) {

            RandomizedQueue rq = new RandomizedQueue();

            rq = enqueueIntegers(rq, i);

            assertEquals(i, rq.size());

        }

    }

    

    @Test

    public void test011() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 100000);

        rq = dequeueIntegers(rq, 50000);

        assertEquals(50000, rq.size());

    }

    

    @Test

    public void test012() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 10);

        assertEquals(10, rq.size());

        rq = dequeueIntegers(rq, 9);

        assertEquals(1, rq.size());

        rq = enqueueIntegers(rq, 5);

        assertEquals(6, rq.size());

        rq = dequeueIntegers(rq, 6);

        assertEquals(0, rq.size());

    }



    @Test

    public void test013() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 100000);

        rq = dequeueIntegers(rq, 90000);

        rq = enqueueIntegers(rq, 50000);

        rq = dequeueIntegers(rq, 60000);

        assertEquals(0, rq.size());

    }

    

    @Test

    public void test014() {

        // test size for 10000 queues, enqueueing 1 to 10000 and dequeing half

        for (int i = 1; i < 10000; i++) {

            RandomizedQueue rq = new RandomizedQueue();

            rq = enqueueIntegers(rq, i);

            rq = dequeueIntegers(rq, i/2);

            assertEquals(i - i/2, rq.size());

        }

    }



    @Test

    public void test015() {

        // test size for one queue, enqueueing 1 to 100 and dequeing half each time

        RandomizedQueue rq = new RandomizedQueue();

        int expectedSize = 0;

        for (int i = 1; i < 100; i++) {

            rq = enqueueIntegers(rq, i);

            expectedSize += i;

            rq = dequeueIntegers(rq, i/2);

            expectedSize -= i/2;

        }

        assertEquals(expectedSize, rq.size());

    }





    @Test

    public void test016() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 5);

        rq = dequeueIntegers(rq, 5);

        rq = enqueueIntegers(rq, 50);

        rq = dequeueIntegers(rq, 50);

        rq = enqueueIntegers(rq, 500);

        rq = dequeueIntegers(rq, 500);

        rq = enqueueIntegers(rq, 1000);

        rq = dequeueIntegers(rq, 1000);

        assertEquals(0, rq.size());

    }



    @Test

    public void test017() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 5);

        rq = enqueueIntegers(rq, 50);

        rq = enqueueIntegers(rq, 500);

        rq = enqueueIntegers(rq, 1000);

        rq = dequeueIntegers(rq, 5);

        rq = dequeueIntegers(rq, 50);

        rq = dequeueIntegers(rq, 500);

        rq = dequeueIntegers(rq, 1000);

        assertEquals(0, rq.size());

    }

    

    @Test

    public void test018() {

        // Enqueue and dequeue 1 integer, 2 integers, up to 1000 on the same queue

        RandomizedQueue rq = new RandomizedQueue();

        for (int i = 1; i <= 1000; i++){

            rq = enqueueIntegers(rq, i);

            rq = dequeueIntegers(rq, i);

            assertEquals(0, rq.size());

        }

    }



    @Test

    public void testIterator001() {

        RandomizedQueue rq = new RandomizedQueue();

        Iterator it = rq.iterator();

        assertFalse(it.hasNext());

    }



    @Test (expected = NoSuchElementException.class)

    public void testIterator002() {

        RandomizedQueue rq = new RandomizedQueue();

        Iterator it = rq.iterator();

        it.next();

    }



    @Test (expected = UnsupportedOperationException.class)

    public void testIterator003() {

        RandomizedQueue rq = new RandomizedQueue();

        Iterator it = rq.iterator();

        it.remove();

    }





    @Test

    public void testIterator004() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 10);

        Iterator it = rq.iterator();

        assertTrue(it.hasNext());

    }

    

    @Test (expected = NoSuchElementException.class)

    public void testIterator005() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 10);

        Iterator it = rq.iterator();

        while (it.hasNext()){

            it.next();

        }

        it.next();

    }



    @Test

    public void testIterator006() {

        RandomizedQueue rq = new RandomizedQueue();

        rq = enqueueIntegers(rq, 10);

        Iterator it = rq.iterator();

        int numIterations = 0;

        while (it.hasNext()){

            numIterations++;

            it.next();

        }

        assertEquals(10, numIterations);

    }



    @Test

    public void testIterator007() {

        /*

         * Test for correct number of iterations for 1000 queues, 

         * enqueueing 1 to 1000 and dequeing half

         */ 

        for (int i = 1; i < 1000; i++) {

            RandomizedQueue rq = new RandomizedQueue();

            rq = enqueueIntegers(rq, i);

            rq = dequeueIntegers(rq, i/2);

            

            Iterator it = rq.iterator();

            int numIterations = 0;

            while (it.hasNext()){

                numIterations++;

                it.next();

            }

            assertEquals(rq.size(), numIterations);

        }

    }



    public RandomizedQueue enqueueIntegers (RandomizedQueue rq, int num) {

        // enqueue a series of numbers

        for (int i = 0; i < num; i++) {

            rq.enqueue(i);

        }

        return rq;

    }



    public RandomizedQueue dequeueIntegers (RandomizedQueue rq, int num) {

        // dequeue a specified number of integers

        while (num > 0) {

            rq.dequeue();

            num--;

        }

        return rq;

    }

}

