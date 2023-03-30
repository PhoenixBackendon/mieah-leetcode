package com.mieah.leetcode._01_array;

public class _2RemoveElementLeetcode21 {


    public static void main(String[] args) {
        _2RemoveElementLeetcode21 test = new _2RemoveElementLeetcode21();
        int[] testArray1 = new int[]{3, 1, 6, 84, 25, 8, 2, 5, 57, 5};
        System.out.println();
        testMethod(testArray1, test._01RemoveElement(testArray1, 5));
        testMethod(testArray1, test._02RemoveElement(testArray1, 5));
    }


    int _01RemoveElement(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            if (nums[leftIndex] == val) {
                nums[leftIndex] = nums[rightIndex];
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return rightIndex + 1;
    }

    int _02RemoveElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    static void testMethod(int[] nums, int len) {
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
