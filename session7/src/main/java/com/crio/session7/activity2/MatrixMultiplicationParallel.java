package com.crio.session7.activity2;

import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplicationParallel {


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        int[][] m1 = MatrixGenerator.generateMatrix(2000, 2000);
        int[][] m2 = MatrixGenerator.generateMatrix(2000, 2000);
      
        int[][] result = new int[m1.length][m2[0].length];
        multiply(m1, m2, result);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
    
        System.out.println(" Multi Thread Duration: " + String.valueOf(duration));
      
    }


    public static void multiply(int[][] matrix1, int[][] matrix2, int[][] result) {
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;
        for (int i = 0; i < rows1; i++) {
         RowMultiplierThread task = new RowMultiplierThread(result, matrix1, matrix2, i);
         Thread thread = new Thread(task);
         thread.start();
         threads.add(thread);
        // create 10 threads at a time because if we create 22000 threads for 22000 x 22000 matrix then the application gets to hang up and possibly out of memory. So we will be using the 10 threads as a group and let them complete then again initiate the next 10 threads until complete each row multiplication.
        // To test OOM, comment all the contents of if block and uncomment line No 40 and run the program.
        // Remember, too many threads are not useful. ideal number of threads to be created is ( if Number of threads == Number of available processors. )
          if (threads.size() % 10 == 0) {
           waitForThreads(threads);
        }
        }
        //waitForThreads(threads);
       }
       
      
       private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
         try {
          thread.join();
         } catch (InterruptedException e) {
          e.printStackTrace();
         }
        }
        threads.clear();
       }
}
