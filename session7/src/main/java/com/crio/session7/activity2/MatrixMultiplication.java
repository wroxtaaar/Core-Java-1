package com.crio.session7.activity2;

public class MatrixMultiplication {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        int[][] m1 = MatrixGenerator.generateMatrix(5, 5);
        int[][] m2 = MatrixGenerator.generateMatrix(5, 5);
      
        multiply(m1, m2);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
    
        System.out.println("Single Thread Duration: " + String.valueOf(duration));

    }
      

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int resultRows = matrix1.length;
        int resultColumns = matrix2[0].length;
      
        int[][] result = new int[resultRows][resultColumns];
      
        int columns2 = matrix2[0].length;
      
        for (int i = 0; i < resultRows; i++) {
         for (int j = 0; j < columns2; j++) {
          result[i][j] = 0;
          for (int k = 0; k < resultColumns; k++) {
           result[i][j] += matrix1[i][k] * matrix2[k][j];
          }
         }
        }
      
        return result;
      
       }
}
