package com.mieah.leetcode._01_array;

import java.util.Arrays;

public class _3SortedSquaresLeetcode977 {

    public static void main(String[] args) {
        _3SortedSquaresLeetcode977 test = new _3SortedSquaresLeetcode977();
        System.out.println(Arrays.toString(test._01sortedSquares(new int[]{-4, 0, 1, 3, 10})));
        System.out.println(Arrays.toString(test._2sortedSquares(new int[]{-4, 0, 1, 3, 10})));
    }

    int[] _01sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = square(nums[i]);
        }
        Arrays.sort(nums);
        return nums;
    }

    int[] _2sortedSquares(int[] nums) {
        int len = nums.length;
        int negative = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }
        int[] squaresNums = new int[len];
        int leftIndex = negative;
        int rightIndex = negative + 1;
        int index = 0;
        while (leftIndex >= 0 || rightIndex < len) {
            if (leftIndex < 0) {
                squaresNums[index++] = square(nums[rightIndex++]);
            } else if (rightIndex == len) {
                squaresNums[index++] = square(nums[leftIndex--]);
            } else if (square(nums[leftIndex]) > square(nums[rightIndex])) {
                squaresNums[index++] = square(nums[rightIndex++]);
            } else {
                squaresNums[index++] = square(nums[leftIndex--]);
            }
        }
        return squaresNums;
    }

    int square(int num) {
        return num * num;
    }
}
