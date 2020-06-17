package com.hyx.dp.match;

/**
 * 正则表达式1
 * 问: 给定一个正则表达式p(只能含有?(匹配1个任意字符)和*(匹配任意字符串))，在给定一个字符串s，判断s是否符合p的规律
 * 
 * @author sq
 * @date 2020/06/16
 */
public class Pattern1 {

    /**
     * 判断是否匹配
     * 
     * @param pattern
     *            正则表达式
     * @param string
     *            要匹配的字符串
     * @return 是否匹配
     */
    public boolean get(final String pattern, final String string) {
        if (pattern == null || string == null) {
            return false;
        }
        if (pattern.isEmpty()) {
            if (string.isEmpty()) {
                return true;
            }
            return false;
        }
        if (string.isEmpty()) {
            for (final char c : pattern.toCharArray()) {
                if (c != '*') {
                    return false;
                }
            }
            return true;
        }
        final boolean[][] dp = new boolean[pattern.length() + 1][string.length() + 1];
        final char[] pChars = pattern.toCharArray();
        final char[] sChars = string.toCharArray();
        dp[0][0] = pChars[0] == '*' ||  pChars[0] == '?' ||  pChars[0] == sChars[0];
        if (!dp[0][0]) {
            return dp[0][0];
        }
        for (int i = 1, iSize = pChars.length + 1; i < iSize; i++) {
            int j = 1, jSize = sChars.length + 1;
            boolean flag = false;
            if (pChars[i - 1] == '*') {
                while (!dp[i - 1][j - 1] && j < jSize) j++;
                dp[i][j - 1] = dp[i - 1][j - 1];
                flag = true;
            }
            for (; j < jSize; j++) {
                dp[i][j] = flag || (dp[i - 1][j - 1] && (pChars[i - 1] == '?' || pChars[i - 1] == sChars[j - 1]));
            }
        }
        return dp[pattern.length()][string.length()];
    }
    
    public static void main(String[] args) {
        Pattern1 pattern = new Pattern1();
        System.out.println(pattern.get("2*a", "1a"));
        System.out.println(pattern.get("1*a", "1a"));
        System.out.println(pattern.get("111*111", "1111111111"));
        System.out.println(pattern.get("1*", "1"));
        System.out.println(pattern.get("1*", "11"));
        System.out.println(pattern.get("?*?", "11"));
        System.out.println(pattern.get("?233", "2233"));
    }

}
