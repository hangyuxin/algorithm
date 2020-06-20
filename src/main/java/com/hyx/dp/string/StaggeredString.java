package com.hyx.dp.string;

/**
 * 交错字符串
 * 问：给定一个字符串s1一个字符串s2一个字符串s3，求s2是否有s1+s2交错而成的
 * 
 * @author sq
 * @date 2020/06/20
 */
public class StaggeredString {
    
    /**
     * 获取string3是否为string1和string2的交错后产生的字符串
     * 
     * @param string1
     *            字符串1
     * @param string2
     *            字符串2
     * @param string3
     *            字符串3
     * @return 是否有1、2组成
     */
    public boolean get(final String string1, final String string2, final String string3) {
        if (string1 == null || string2 == null || string3 == null) {
            return false;
        }
        if (string1.length() + string2.length() != string3.length()) {
            return false;
        }
        if (string1.isEmpty()) {
            if (string2.equals(string3)) {
                return true;
            }
            return false;
        }
        if (string2.isEmpty()) {
            if (string1.equals(string3)) {
                return true;
            }
            return false;
        }
        if (string3.isEmpty()) {
            return true;
        }
        final boolean dps[][] = new boolean[string1.length() + 1][string2.length() + 1];
        final char[] chars1 = string1.toCharArray();
        final char[] chars2 = string2.toCharArray();
        final char[] chars3 = string3.toCharArray();
        dps[0][0] = chars1[0] == chars3[0] || chars2[0] == chars3[0];
        if (!dps[0][0]) {
            return false;
        }
        for (int i = 1, size = chars1.length + 1; i < size; i++) {
            if (dps[i - 1][0] && chars1[i - 1] == chars3[i - 1]) {
                dps[i][0] = true;
            }
        }
        for (int i = 1, size = chars2.length + 1; i < size; i++) {
            if (dps[0][i - 1] && chars2[i - 1] == chars3[i - 1]) {
                dps[0][i] = true;
            }
        }
        for (int i = 1, iSize = chars1.length + 1; i < iSize; i++) {
            for (int j = 1, jSize = chars2.length  + 1; j < jSize; j++) {
                if (dps[i][j - 1] && chars2[j - 1] == chars3[i + j - 1]
                    || dps[i - 1][j] && chars1[i - 1] == chars3[i + j - 1]) {
                    dps[i][j] = true;
                }
            }
        }
        return dps[string1.length()][string2.length()];
    }
    
    public static void main(String[] args) {
        final StaggeredString staggeredString = new StaggeredString();
        System.out.println(staggeredString.get("aabcc", "dbbca", "aadbbbccac"));
        System.out.println(staggeredString.get("aabcc", "dbbca", "aabbdbccca"));
    }

}
