package com.hyx.greedy.money;

/**
 * 钱 实体类
 * @author sq
 * @date 2020/06/05
 */
public class Money {
    
    /**
     * 面值
     */
    private final int faceValue;
    
    /**
     * 单当前剩余数量
     */
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getFaceValue() {
        return faceValue;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + faceValue;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Money other = (Money)obj;
        if (faceValue != other.faceValue)
            return false;
        return true;
    }

    public Money(int faceValue, int num) {
        super();
        this.faceValue = faceValue;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Money [faceValue=" + faceValue + ", num=" + num + "]";
    }
    
}
