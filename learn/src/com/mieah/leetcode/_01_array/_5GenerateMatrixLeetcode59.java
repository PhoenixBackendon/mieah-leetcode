package com.mieah.leetcode._01_array;

import java.util.Arrays;

public class _5GenerateMatrixLeetcode59 {

    public static void main(String[] args) {
        _5GenerateMatrixLeetcode59 test = new _5GenerateMatrixLeetcode59();
        System.out.println(Arrays.deepToString(test._01generateMatrix(1)));
        System.out.println(Arrays.deepToString(test._01generateMatrix(2)));
        System.out.println(Arrays.deepToString(test._01generateMatrix(3)));
        System.out.println(Arrays.deepToString(test._01generateMatrix(4)));
        System.out.println(Arrays.deepToString(test._01generateMatrix(5)));
        System.out.println(Arrays.deepToString(test._02generateMatrix(1)));
        System.out.println(Arrays.deepToString(test._02generateMatrix(2)));
        System.out.println(Arrays.deepToString(test._02generateMatrix(3)));
        System.out.println(Arrays.deepToString(test._02generateMatrix(4)));
        System.out.println(Arrays.deepToString(test._02generateMatrix(5)));
    }

    int[][] _01generateMatrix(int n) {
        if (1 == n) {
            return new int[][]{{1}};
        }
        int leftIndex = 0;
        int upIndex = 0;
        int rightIndex = n - 1;
        int downIndex = n - 1;

        int[][] matrix = new int[n][n];
        int value = 1;
        while (leftIndex <= rightIndex && upIndex <= downIndex) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                matrix[upIndex][i] = value++;
            }
            upIndex++;
            for (int i = upIndex + 1; i <= downIndex; i++) {
                matrix[i][rightIndex] = value++;
            }
            rightIndex--;
            for (int i = rightIndex - 1; i >= leftIndex; i--) {
                matrix[downIndex][i] = value++;
            }
            downIndex--;
            for (int i = downIndex - 1; i >= upIndex; i--) {
                matrix[i][leftIndex] = value++;
            }
            leftIndex++;
        }
        return matrix;
    }

    int[][] _02generateMatrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }
        int[][] matrix = new int[n][n];
        int num = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int coloum = left; coloum <= right; coloum++) {
                matrix[top][coloum] = num++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            if (left < right && top < bottom) {
                for (int coloum = right - 1; coloum >= left; coloum--) {
                    matrix[bottom][coloum] = num++;
                }
                for (int row = bottom - 1; row > top; row--) {
                    matrix[row][left] = num++;
                }
            }
            top++;
            bottom--;
            right--;
            left++;
        }
        return matrix;
    }
}
