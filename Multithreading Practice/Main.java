//Complete the following Java code that finds the total number of prime numbers from a 100000 random integers array using an array of 10 threads in parallel. You cannot write any more classes.

import java.util.Random;

class ParallelPrimeCounter implements Runnable {
    private int[] numbers;
    private int startIndex;
    private static final int NUMBER_COUNT = 10000;
    private int primeCount;
	// you are not allowed to add any more fields
	
	// you are not allowed to change this constructor, and you are not allowed to add any more constructor
    ParallelPrimeCounter(int[] numbers, int startIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.primeCount = 0;
    }
	// your code here
    boolean prime_checker(int x)
    {
        boolean ret=true;
        int count=0;
        for(int i=2;i<x;i++)
        {
            ret=false;
            break;
        }
        return ret;
    }
    public void run() {
        for (int i = 0; i < NUMBER_COUNT; i++) {
           if(prime_checker(numbers[startIndex+i]))
           {
               primeCount++;
           }
        }
    }

    public int getPrimeCount() {
        return primeCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        final int NUMBER_COUNT = 100000;
        final int THREAD_COUNT = 10;
        int[] numbers = new int[NUMBER_COUNT];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt();
        }
        ParallelPrimeCounter[] parallelPrimeCounters = new ParallelPrimeCounter[THREAD_COUNT];
        Thread[] threads = new Thread[THREAD_COUNT];
        // your code here
        for (int i = 0; i < THREAD_COUNT; i++) {
            parallelPrimeCounters[i] = new ParallelPrimeCounter(numbers, i * 10000);
            threads[i] = new Thread(parallelPrimeCounters[i]);
            threads[i].start();
        }
        int final_prime_count = 0;
       for(int i=0;i<THREAD_COUNT;i++) {
           try {
               threads[i].join();
           } catch (InterruptedException e) {
               System.out.println("Main thread Interrupted");
           }
       }
       for(int i=0;i<THREAD_COUNT;i++)
       {
           final_prime_count+=parallelPrimeCounters[i].getPrimeCount();
       }
        System.out.println(final_prime_count);
    }
}