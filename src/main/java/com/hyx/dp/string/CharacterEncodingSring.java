package com.hyx.dp.string;

/**
 * 字符编码
 * 给定一个只包含数字的字符串， 字符串内的字符按以下编码来编码吗，1-a、2-b …… 26-z
 * 求最多可以转换出多少种字符串
 * 
 * @author sq
 * @date 2020/06/26
 */
public class CharacterEncodingSring {
    
    /**
     * 获取最多可以转换出多少种字符串
     * 
     * @param string
     *            以编码的字符串
     * @return 最大数量
     */
    public int get(final String string) {
        if (string == null) {
            return -1;
        }
        if (string.isEmpty()) {
            return 0;
        }
        final char[] chars = string.toCharArray();
        int size = chars.length;
        for (int i = 0; i < size; i++) {
            if (chars[i] == 48) {
                if (i == 0) {
                    return -1;
                }
                if (chars[i - 1] != 50 && chars[i - 1] != 49) {
                    return -1;
                }
            } else {
                if (chars[i] > 57 || chars[i] < 49) {
                    return -1;
                }
            }
        }
        if (chars.length < 2) {
            return 1;
        }
        final int[] dps = new int[size];
        dps[0] = 1;
        int num = Integer.valueOf("" + chars[0] + chars[1]);
        if (num == 10 || num == 20) {
            dps[1] = 1;
        } else {
            if (num > 26) {
                dps[1] = 1;
            } else {
                dps[1] = 2;
            }
        }
        for (int i = 2; i < size; i++) {
            if (chars[i] == '0') {
                if (chars[i - 2] == '0') {
                    dps[i] = dps[i - 1];
                } else {
                    if (dps[i - 1] != dps[i -2]) {
                        dps[i - 1] = dps[i - 2];
                    }
                    dps[i] = dps[i - 1];
                }
            } else {
                if (chars[i - 1] == '0') {
                    dps[i] = dps[i - 1];
                } else {
                    num = Integer.valueOf("" + chars[i - 1] + chars[i]);
                    if (num > 26) {
                        dps[i] = dps[i - 1];
                    } else {
                        dps[i] = dps[i - 1] + dps[i - 2];
                    }
                }
            }
        }
        return dps[size - 1];
    }
    
    public static void main(String[] args) {
        final CharacterEncodingSring characterEncodingSring = new CharacterEncodingSring();
        System.out.println(characterEncodingSring.get("12"));
        System.out.println(characterEncodingSring.get("2222"));
        System.out.println(characterEncodingSring.get("206"));
        System.out.println(characterEncodingSring.get("276"));
        System.out.println(characterEncodingSring.get("101"));
        System.out.println(characterEncodingSring.get("110"));
        System.out.println(characterEncodingSring.get("227"));
    }

}
