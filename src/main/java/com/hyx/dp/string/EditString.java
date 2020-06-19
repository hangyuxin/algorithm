package com.hyx.dp.string;

/**
 * 编辑字符串距离
 * 问：给定两个字符串s1，s2，你可以对s1和s2进行任何操作(每次操作只可以动一个字符，删除、插入和修改)，
 * 求将s1和s2变为相等字符串最少需要操作几次？
 * 
 * @author sq
 * @date 2020/06/19
 */
public class EditString {
    
    /**
     * 求s1转为s2的最小操作数
     * 
     * @param string1
     *            s1
     * @param string2
     *            s2
     * @return 最小操作数
     */
    public int get(final String string1, final String string2) {
        if (string1 == null || string2 == null) {
            return -1;
        }
        if (string1.isEmpty()) {
            if (string2.isEmpty()) {
                return 0;
            }
            return string2.length();
        }
        if (string2.isEmpty()) {
            return string1.length();
        }
        final char[] chars1 = string1.toCharArray();
        final char[] chars2 = string2.toCharArray();
        final int[][] dps = new int[chars1.length + 1][chars2.length + 1];
        dps[0][0] = 0;
        for (int i = 1, size = chars1.length + 1; i < size; i++) {
            dps[i][0]  = dps[i - 1][0] + 1;
        }
        for (int i = 1, size = chars2.length + 1; i < size; i++) {
            dps[0][i]  = dps[0][i - 1] + 1;
        }
        for (int i = 1, iSize = chars1.length + 1; i < iSize; i++) {
            for (int j = 1, jSize = chars2.length + 1; j < jSize; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dps[i][j] = dps[i - 1][j - 1];
                } else {
                    dps[i][j] = Math.min(Math.min(dps[i - 1][j - 1], dps[i - 1][j]), dps[i][j - 1]) + 1;
                }
            }
        }
        return dps[chars1.length][chars2.length];
    }
    
    public static void main(String[] args) {
        final EditString editString = new EditString();
        System.out.println(editString.get("abcde", "fbe"));
        System.out.println(editString.get("horse", "ros"));
        System.out.println(editString.get("intention", "execution"));
        System.out.println(editString.get("abcde", "fbde"));
    }

}
