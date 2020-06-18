package com.hyx.dp.string;

/**
 * 扰乱字符串
 * 问：
 * 给定一个字符串s，可以依据任何节点将字符串划分为两个非空子字串，一直划分为每个子字符串都只有一个字符，
 * 然后可以任意n个节点旋转一次来得出一个字符串s1
 * 在给定一个字符串s2，求s2是否为s1
 * 
 * @author sq
 * @date 2020/06/18
 */
public class DisturbString {
    
    public boolean get(final String string, final String string1) {
        if (string == null || string1 == null) {
            return false;
        }
        if (string.length() != string1.length()) {
            return false;
        }
        if (string.equals(string1)) {
            return true;
        }
        final char[] chars1 = string.toCharArray();
        final char[] chars2 = string1.toCharArray();
        // 判断字符串中所有字符出现的频率是否相同
        {
            int[] arrays = new int[26];
            for (int i = 0, size = chars1.length; i < size; i++) {
                arrays[chars1[i] - 'a']++;
                arrays[chars2[i] - 'a']--;
            }
            for (final int i : arrays) {
                if (i != 0) {
                    return false;
                }
            }
        }
        int length = chars1.length;
        final boolean[][][] dps = new boolean[length + 1][length][length];
        for (int i = 1, iSize = length + 1; i < iSize; i++) {
            for (int j = 0; j + i < iSize; j++) {
                for (int k = 0; k + i < iSize; k++) {
                    if (i == 1) {
                        dps[i][j][k] = chars1[j] == chars2[k];
                    } else {
                        for (int l = 1; l < i; l++) {
                            dps[i][j][k] = dps[l][j][k] && dps[i - l][j + l][k + l]
                                || dps[l][j][k + i - l] && dps[i - l][j + l][k];
                            if (dps[i][j][k]) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dps[chars1.length][0][0];
    }
    
    public static void main(String[] args) {
        final DisturbString disturbString = new DisturbString();
        System.out.println(disturbString.get("great", "rgeat"));
        System.out.println(disturbString.get("great", "rgtae"));
        System.out.println(disturbString.get("great", "rgate"));
        System.out.println(disturbString.get("abcde", "caebd"));
    }

}
