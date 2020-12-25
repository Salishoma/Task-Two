package com.codewars;

public class Main {

    public static void main(String[] args) {
        int sum = MatrixDeterminant.determinant(new int[][]{{1, -3, -4, 8, -6, 7, 10, 6},{-3, -3, 5, 5, 7, -4, -5, 5},{5, 1, 8, -8, -4, -3, 2, -1},
                {-6, 7, -2, 8, 9, 9, 0, -9},{8, 9, 7, -2, -5, 7, -9, -1}, {-2, -8, -5, 4, 6, 7, 2, 1}, {9, 10, 5, -5, 7, -9, 6, -1}, {7, 9, 7, 9, 6, 2, 4, 9}});

//        int sum = determinant(new int[][]{{5, -1, -7, -5}, {-6, -2, -10, 1}, {-1, -6, -10, 0}, {-9, 0, -8, -6}});
        System.out.println(sum);
    }
}
