package com.codewars;

public class MatrixDeterminant {

    public static int determinant(int[][] matrix) {
        if(matrix.length == 1) return matrix[0][0];
        int sum = 0;
        for(int i = 0; i < matrix[0].length; i++){
            int[][] arr1 = new int[matrix.length - 1][matrix[0].length - 1];
            int m = 0;
            for(int j = 1; j < matrix.length; j++){
                int[] arr2 = new int[matrix[0].length - 1];
                int l = 0;
                for(int k = 0; k < matrix[0].length; k++){
                    if(k != i){
                        arr2[l] = matrix[j][k];
                        l++;
                    }
                }
                arr1[m] = arr2.clone();
                m++;
            }
            sum += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * determinant(arr1);
        }
        return sum;
    }
}
