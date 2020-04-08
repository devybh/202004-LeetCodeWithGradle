package edu.devybh.leetcode.solutions;

import edu.devybh.leetcode.Util;

import java.util.Arrays;

public class Solution_0001_TwoSum extends AbstractSolution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            int n1 = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                int n2 = nums[j];
                if (n1 + n2 == target) return new int[]{i, j};
            }
        }
        return null;
    }

    @Override
    public Solution_0001_TwoSum setTestCases() {
        // 문제1
        this.newTestCase()
                .setInput(new int[]{2, 7, 11, 15})
                .setInput(9)
                .setOutput(new int[]{0, 1});

        return this;
    }
}
