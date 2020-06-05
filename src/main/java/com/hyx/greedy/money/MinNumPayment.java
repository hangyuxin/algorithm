package com.hyx.greedy.money;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数字，和一组钞票，求出怎么样付款才可以付出最少的钱,并给出付款策略
 * 本算法采用的是贪心算法，每一次只求出当前最大的钱，最后讲所有钱汇总返回
 * 
 * @author sq
 * @date 2020/06/05
 */
public class MinNumPayment {

    /**
     * 求出最少付款额,并给出付款策略
     * 
     * @param amount
     *            要付的钱
     * @param moneys
     *            当前存在的钱
     * @return 付款策略，为null时代表无法付款
     */
    public Money[] get(int amount, final Money[] moneys) {
        final List<Money> list = new LinkedList<>();
        while (amount > 0) {
            final Money money = this.getMaxMoney(moneys, amount);
            if (money == null) {
                final Money money2 = this.getMoreThanTheMoney(moneys, amount);
                if (money2 == null) {
                    return null;
                }
                amount -= money2.getFaceValue();
                this.addMoney(list, money2);
                break;
            }
            amount -= money.getFaceValue();
            money.setNum(money.getNum() - 1);
            this.addMoney(list, money);
        }
        return this.resultHandle(list, amount);
    }
    
    /**
     * 处理 贪心算法带来的bug
     * @param moneys
     * @param amount
     * @return
     */
    private Money[] resultHandle(final List<Money> moneys, int amount) {
        if (amount < 0) {
            final Iterator<Money> iterator = moneys.iterator();
            while (iterator.hasNext()) {
                final Money money = iterator.next();
                if (money.getFaceValue() <= Math.abs(amount)) {
                    int num = Math.abs(amount) / money.getFaceValue();
                    if (money.getNum() <= num) {
                        iterator.remove();
                        amount += money.getNum() * money.getFaceValue();
                    } else {
                        money.setNum(money.getNum() - num);
                        amount += money.getNum() * num;
                    }
                }
                
            }
        }
        return moneys.toArray(new Money[moneys.size()]);
    }

    /**
     * 获取小于最大面额的钱
     * 
     * @param moneys
     *            当前剩余的钱
     * @param maxMoney
     *            最大面额
     * @return 符合要求的钱，找不到返回null
     */
    private Money getMaxMoney(final Money[] moneys, final int maxMoney) {
        Money money = null;
        for (final Money money1 : moneys) {
            if (money1.getNum() < 1) {
                continue;
            }
            if (money == null) {
                if (money1.getFaceValue() <= maxMoney) {
                    money = money1;
                }
            } else {
                if (money.getFaceValue() < money1.getFaceValue()) {
                    money = money1;
                }
            }
        }
        return money;
    }
    
    /**
     * 获取最小的大于指定钱的钱
     * 
     * @param moneys
     *            当前剩余的钱
     * @param money
     *            指定的钱
     * @return 符合要求的钱，找不到返回null
     */
    private Money getMoreThanTheMoney (final Money[] moneys, final int money) {
        Money money2 = null;
        for (final Money money1 : moneys) {
            if (money1.getNum() < 1) {
                continue;
            }
            if (money2 == null) {
                if (money1.getFaceValue() >= money) {
                    money2 = money1;
                }
            } else {
                if (money2.getFaceValue() > money1.getFaceValue() && money1.getFaceValue() >= money) {
                    money2 = money1;
                }
            }
        }
        return money2;
    }
    
    /**
     * 将钱添加到list中
     * 
     * @param moneys
     *            要添加到哪里
     * @param money
     *            要添加的钱
     */
    private void addMoney(final List<Money> moneys, final Money money) {
        for (final Money money1 : moneys) {
            if (money1.equals(money)) {
                money1.setNum(money1.getNum() + 1);
                return;
            }
        }
        moneys.add(new Money(money.getFaceValue(), 1));
    }

    public static void main(String[] args) {
        final MinNumPayment minNumPayment = new MinNumPayment();
        System.out.println(Arrays.toString(minNumPayment.get(358, new Money[] {new Money(100, 4), new Money(20, 4),
            new Money(50, 0), new Money(10, 4), new Money(5, 1), new Money(1, 2)})));
    }

}
