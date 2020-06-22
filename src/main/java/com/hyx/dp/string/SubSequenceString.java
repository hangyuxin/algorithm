package com.hyx.dp.string;

import java.util.Arrays;

/**
 * 不同子序列
 * 问：给定一个字符串s1，一个字符串s2。你可以对s1进行删除字符操作，求将s1变换为s2最多有几种方式
 * 
 * @author sq
 * @date 2020/06/22
 */
public class SubSequenceString {
    
    /**
     * 获取不同子序列的值
     * 
     * @param string1
     *            字符串1
     * @param string2
     *            字符串2
     * @return 值
     */
    public int get(final String string1, final String string2) {
        if (string1 == null || string2 == null) {
            return -1;
        }
        if (string1.isEmpty()) {
            if (string2.isEmpty()) {
                return 1;
            }
            return 0;
        }
        if (string2.isEmpty()) {
            return 1;
        }
        if (string1.length() <= string2.length()) {
            if (string1.equals(string2)) {
                return 1;
            }
            return 0;
        }
        final char[] chars1 = string1.toCharArray();
        final char[] chars2 = string2.toCharArray();
        /*final int[][] dps = new int[string2.length() + 1][string1.length() + 1];
        Arrays.fill(dps[0], 1);
        for (int i = 1, iSize = chars2.length + 1; i < iSize; i++) {
            for (int j = 1, jSize = chars1.length + 1; j < jSize; j++) {
                if (chars2[i - 1] == chars1[j - 1]) {
                    dps[i][j] = dps[i - 1][j - 1] + dps[i][j - 1];
                } else {
                    dps[i][j] = dps[i][j - 1];
                }
            }
        }
        return dps[string2.length()][string1.length()];*/
        final int[] dps = new int[string2.length() + 1];
        dps[0] = 1;
        for (int i = 1, iSize = chars1.length + 1; i < iSize; i++) {
            for (int j = chars2.length; j > 0; j--) {
                if (chars2[j - 1] == chars1[i - 1]) {
                    dps[j] += dps[j - 1];
                }
            }
        }
        return dps[string2.length()]; 
    }
    
    public static void main(String[] args) {
        final SubSequenceString sequenceString = new SubSequenceString();
        System.out.println(sequenceString.get("rabbbit", "rabbit"));
        System.out.println(sequenceString.get("babgbag", "bag"));
    }

}