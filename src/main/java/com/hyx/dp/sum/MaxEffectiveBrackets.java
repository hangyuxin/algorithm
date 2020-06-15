package com.hyx.dp.sum;

/**
 * 最大有效括号长度
 * 问：
 * 给定一个字符串s，s中只包含'('和')'这两种字符，求s中最长的合法括号长度
 * 
 * @author sq
 * @date 2020/06/15
 */
public class MaxEffectiveBrackets {
    
    /**
     * 获取最大有效括号对
     * 
     * @param string
     *            要获取的字符串
     * @return 最大长度
     */
    public int get(final String string) {
        if (string == null || string.length() < 2) {
            return 0;
        }
        final char[] chars = string.toCharArray();
        for (final char c : chars) {
            if (c != '(' && c != ')') {
                return 0;
            }
        }
        final int[] dp = new int[string.length()];
        dp[0] = 0;
        if (chars[0] == '(' && chars[1] == ')') {
            dp[1] = 2;
        } else {
            dp[1] = 0;
        }
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2, size = chars.length; i < size; i++) {
            if (chars[i] == '(') {
                dp[i] = 0;
            } else {
                if (chars[i - 1] == '(') {
                    dp[i] = 2 + dp[i - 2];
                } else {
                    if (dp[i - 1] != 0 && (i - dp[i - 1] - 1) > -1 && chars[i - dp[i - 1] - 1] == '(') {
                        dp[i] =  dp[i - 1] + 2;
                    } else {
                        dp[i] = 0;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new MaxEffectiveBrackets().get("((())()()))"));
    }

}
