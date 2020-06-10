package com.hyx.dp.match;

/**
 * 给定一个正则表达式p(只能含有.(匹配1个任意字符)和*(匹配0~n个*号前面的字符))，在给定一个字符串s，判断s是否符合p的规律
 * 
 * @author sq
 * @date 2020/06/09
 */
public class Pattern {
    
    /**
     * 判断是否匹配
     * 
     * @param p
     *            正则表达式
     * @param s
     *            要匹配的字符串
     * @return 是否匹配
     */
    public boolean match(String p, final String s) {
        if (p ==  null || s == null || p.isEmpty() || s.isEmpty()) {
            return false;
        }
        p = this.handlePattern(p);
        if (p.isEmpty()) {
            return false;
        }
        final boolean[][] dps = new boolean[s.length()][p.length()];
        final char[] scs = s.toCharArray();
        final char[] pcs = p.toCharArray();
        for (int i = 0, iSize = scs.length; i < iSize;  i++) {
            for (int j = 0, jSize = pcs.length; j < jSize;  j++) {
                if (pcs[j] == '*') {
                    if (i == 0) {
                        dps[i][j] = pcs[j - 1] == '.' || scs[i] == pcs[j - 1];
                    } else {
                        dps[i][j] = dps[i - 1][j - 1] && (dps[i][j - 1] || pcs[j - 1] == '.' || scs[i] == pcs[j - 1]);
                    }
                } else {
                    if (i == 0) {
                        dps[i][j] = pcs[j] ==  '.' || pcs[j] ==  scs[i];
                    } else {
                        dps[i][j] = dps[i - 1][j] && (scs[i - 1] == pcs[j] || pcs[j] == '.');
                    }
                }
            }
        }
        return dps[s.length() - 1][p.length() - 1];
    }
    
    /**
     * 处理正则表达式，删去前面和中间的无效*
     * 
     * @param pattern
     *            要处理的正则
     * @return 处理后的正则
     */
    private String handlePattern(final String pattern) {
        final StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        boolean flag1 = false;
        for (final char c : pattern.toCharArray()) {
            if (flag) {
                if (c != '*') {
                    flag = false;
                    stringBuilder.append(c);
                }
            } else {
                if (flag1) {
                    if (c != '*') {
                        stringBuilder.append(c);
                        flag1 = false;
                    }
                } else {
                    if (c == '*') {
                        stringBuilder.append(c);
                        flag1 = true;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
    
    public static void main(String[] args) {
        final Pattern pattern = new Pattern();
        System.out.println(pattern.match("1*a", "1a"));
        System.out.println(pattern.match("111*111", "1111111111"));
        System.out.println(pattern.match("1*", "1"));
        System.out.println(pattern.match("1*", "11"));
        System.out.println(pattern.match(".*.", "11"));
    }

}
