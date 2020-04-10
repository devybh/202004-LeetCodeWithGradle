package edu.devybh.leetcode.solutions;

import java.util.Arrays;

public class Solution_0007_Reverse extends AbstractSolution {

    public int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] chars = String.valueOf(x).toCharArray();
        boolean isNegative = (chars[0] == '-');
        int startIndex = isNegative ? 1 : 0;
        if (isNegative) stringBuilder.append('-');

        for (int i = chars.length-1; startIndex <= i; --i) {
            stringBuilder.append(chars[i]);
        }

        int result;
        try {
            result = Integer.parseInt(stringBuilder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        return result;
    }

    @Override
    public Solution_0007_Reverse setTestCases() {

        this.newTestCase()
                .setInput(123)
                .setOutput(321);

        this.newTestCase()
                .setInput(-123)
                .setOutput(-321);

        this.newTestCase()
                .setInput(120)
                .setOutput(21);

        this.newTestCase()
                .setInput(1534236469)
                .setOutput(0);

        return this;
    }
}
