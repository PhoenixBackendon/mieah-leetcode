package com.mieah.leetcode._01_array;

public class _1BinarySearchLeetcode704 {
    public static void main(String[] args) {
        _1BinarySearchLeetcode704 test = new _1BinarySearchLeetcode704();
        System.out.println(test._01_search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(test._01_search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(test._02_search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(test._02_search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    private int _01_search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int leftIndex = 0;
        int rightIndex = nums.length;
        while (rightIndex > leftIndex) {
            int middleIndex = leftIndex + rightIndex >> 1;
            if (nums[middleIndex] > target) {
                rightIndex = middleIndex;
            } else if (nums[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }
        return -1;
    }

    private int _02_search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (rightIndex >= leftIndex) {
            int middleIndex = leftIndex + rightIndex >> 1;
            if (nums[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            } else if (nums[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }
        return -1;
    }
}
