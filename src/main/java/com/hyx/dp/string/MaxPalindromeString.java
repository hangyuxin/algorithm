package com.hyx.dp.string;


/**
 * 最大回文子串
 * 问：给定一个字符串s1，求s1中的最大回文子串
 * 
 * @author sq
 * @date 2020/06/23
 */
public class MaxPalindromeString {
    
    public String get(final String string) {
        if (string == null) {
            return null;
        }
        if (string.length() < 2) {
            return string;
        }
        final boolean[][] dps = new boolean[string.length()][string.length()];
        final char[] chars = string.toCharArray();
        for (int i = 0, size = chars.length; i < size; i++) {
            dps[i][i] = true;
        }
        int maxNum = 0, num = 0;
        for (int i = 1, size = chars.length; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] != chars[j]) {
                    dps[j][i] = false;
                } else {
                    if (i - j < 3) {
                        dps[j][i] = true;
                    } else {
                        dps[j][i] = dps[j + 1][i - 1];
                    }
                }
                if (dps[j][i] && i - j > maxNum) {
                    maxNum = i - j;
                    num = j;
                }
            }
        }
        return string.substring(num, maxNum + num + 1);
    }
    
    /**
     * 获取回文串dp数组
     * 
     * @param string
     *            要获取的回文串
     * @return dp数组
     */
    public boolean[][] getPalindrome(final String string) {
        final boolean[][] dps = new boolean[string.length()][string.length()];
        final char[] chars = string.toCharArray();
        for (int i = 0, size = chars.length; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (chars[i] == chars[j] && (i - j  < 3 || dps[j + 1][i - 1])) {
                    dps[j][i] = true;
                }
            }
        }
        return dps;
    }
    
    public static void main(String[] args) {
        final MaxPalindromeString maxPalindromeString = new MaxPalindromeString();
        System.out.println(maxPalindromeString.get("babad"));
        System.out.println(maxPalindromeString.get("cbbd"));
    }

}
