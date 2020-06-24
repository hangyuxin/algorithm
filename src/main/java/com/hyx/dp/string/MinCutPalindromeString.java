package com.hyx.dp.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 最小切割回文串
 * 问： 给定一个字符串s，通过n次切割，使s的每个子串都是回文串，求n最小为多少
 * 
 * @author sq
 * @date 2020/06/24
 */
public class MinCutPalindromeString {
    
    /**
     * 求切割的最小次数
     * 
     * @param string
     *            要切割的字符串
     * @return 最小次数
     */
    public int get(final String string) {
        if (string == null) {
            return -1;
        }
        if (string.length() < 2) {
            return 0;
        }
        final int[] dps = new int[string.length()];
        for (int i = 0, size = dps.length; i < size; i++) {
            dps[i] = i;
        }
        final MaxPalindromeString maxPalindromeString = new MaxPalindromeString();
        final boolean[][] palindromeDps = maxPalindromeString.getPalindrome(string);
        //final List<Character> chars = string.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        for (int i = 1, iSize = string.length(); i < iSize; i++) {
            /*if (this.isPalindrome(chars.subList(0, i + 1))) {
                dps[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (this.isPalindrome(chars.subList(j + 1, i + 1))) {
                        dps[i] = Math.min(dps[i], dps[j] + 1);
                    }
                }
            }*/
            if (palindromeDps[0][i]) {
                dps[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (palindromeDps[j + 1][i]) {
                        dps[i] = Math.min(dps[i], dps[j] + 1);
                    }
                }
            }
        }
        return dps[string.length() -1];
    }

    /**
     * 判断传入的字符数组是否为回文串
     * 
     * @param string
     *            要检查的字符数组
     * @return 是否为回文串
     */
    /*private boolean isPalindrome(final List<Character> chars) {
        for (int i = 0, size = chars.size() - 1; i < size;) {
            if (chars.get(i++) != chars.get(size--)) {
                return false;
            }
        }
        return true;
    }*/
    
    public static void main(String[] args) {
        final MinCutPalindromeString minCutPalindromeString = new MinCutPalindromeString();
        System.out.println(minCutPalindromeString.get("aab"));
        System.out.println(minCutPalindromeString.get("aab1cc"));
        System.out.println(minCutPalindromeString.get("aaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(minCutPalindromeString.get("1a1bb1a1bb1a2"));
    }

}
