package com.hyx.statemachine.finite;

/**
 * 数字有效性
 * 问: 给定一个字符串s，判断s是否为一个正确的十进制数字，可以包括(+,-,e,.,[0-9])
 * 解：
 * 使用有限状态机，状态迁移图请查看com.hyx.statemachine.finite.VerificationNumberStateMachine.png
 * 
 * @author sq
 * @date 2020/06/17
 */
public class VerificationNumber {
    
    /**
     * 验证是否为数字
     * 
     * @param string
     *            要验证的字符串
     * @return 是否位数字
     */
    public boolean get(final String string) {
        final int[][] states = new int[][] {
            {0, 1, 6, 2, -1, -1}, 
            {-1, -1, 6, 2, -1, -1}, 
            {-1, -1, 3, -1, -1, -1}, 
            {8, -1, 3, -1, 4, -1}, 
            {-1, 7, 5, -1, -1, -1}, 
            {8, -1, 5, -1, -1, -1}, 
            {8, -1, 6, 3, 4, -1}, 
            {-1, -1, 5, -1, -1, -1}, 
            {8, -1, -1, -1, -1, -1}
        };
        final boolean[] results = new boolean[] {false, false, false, true, false, true, true, false, true};
        int state = 0;
        for (final char c : string.toCharArray()) {
            state = states[state][this.make(c)];
            if (state == -1) {
                return false;
            }
        }
        return results[state];
    }
    
    /**
     * 获取当前位的状态
     * 
     * @param c
     *            要获取的字符
     * @return 状态
     */
    private int make(char c) {
        switch (c) {
            case ' ':
                return 0;
            case '+' : 
                return 1;
            case '-':
                return 1;
            case 'e' : 
                return 4;
            case '.' : 
                return 3;
            default:
                if (c > 47 && c < 58) {
                    return 2;
                }
                return 5;
        }
    }
    
    public static void main(String[] args) {
        final VerificationNumber verificationNumber = new VerificationNumber();
        System.out.println(verificationNumber.get(" 0"));
        System.out.println(verificationNumber.get("+1"));
        System.out.println(verificationNumber.get("1.0 "));
        System.out.println(verificationNumber.get("1a"));
        System.out.println(verificationNumber.get("2e2"));
        System.out.println(verificationNumber.get("-901e2"));
        System.out.println(verificationNumber.get("1e2.5"));
        System.out.println(verificationNumber.get("8e-6"));
        System.out.println(verificationNumber.get("2.5e-2"));
        System.out.println(verificationNumber.get("e3"));
        System.out.println(verificationNumber.get("e+3"));
        System.out.println(verificationNumber.get("-+3"));
        System.out.println(verificationNumber.get("--3"));
        System.out.println(verificationNumber.get("++3"));
        System.out.println("(aaa)".substring(1, "(aaa)".length() - 1));
    }

}
