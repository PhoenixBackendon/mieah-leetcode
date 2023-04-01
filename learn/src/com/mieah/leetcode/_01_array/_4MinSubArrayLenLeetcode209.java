package com.mieah.leetcode._01_array;

public class _4MinSubArrayLenLeetcode209 {

    public static void main(String[] args) {
        _4MinSubArrayLenLeetcode209 test = new _4MinSubArrayLenLeetcode209();
        System.out.println(test._01minSubArrayLen(new int[]{12,28,83,4,25,26,25,2,25,25,25,12}, 213));
        System.out.println(test._02minSubArrayLen(new int[]{12,28,83,4,25,26,25,2,25,25,25,12}, 213));
    }

    int _01minSubArrayLen(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        } else if (nums[0] >= target) {
            return 1;
        }
        int len = Integer.MAX_VALUE;
        int fastIndex = 1;
        int slowIndex = 0;
        int sum = nums[slowIndex];

        while (fastIndex < nums.length) {
            sum += nums[fastIndex];

            if (sum >= target) {
                int indexLen = fastIndex - slowIndex + 1;
                len = Math.min(len, indexLen);
                while (sum >= target) {
                    sum -= nums[slowIndex++];
                    if (sum >= target) {
                        indexLen = fastIndex - slowIndex + 1;
                        len = Math.min(len, indexLen);
                    }
                }
            }
            fastIndex++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    int _02minSubArrayLen(int[] nums, int target) {
        int numLen = nums.length;
        if (numLen == 0) {
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (rightIndex < numLen) {
            sum += nums[rightIndex];
            if (sum >= target) {
                while (sum >= target) {
                    len = Math.min(len, rightIndex - leftIndex + 1);
                    sum -= nums[leftIndex++];
                }
            }
            rightIndex++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
