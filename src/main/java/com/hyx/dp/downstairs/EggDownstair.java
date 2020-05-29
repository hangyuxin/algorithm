package com.hyx.dp.downstairs;

/**
 * 问：动态规划-鸡蛋下楼问题，假设有N个鸡蛋H层楼，求出在最坏情况下至少要扔多少次可以求出鸡蛋不被摔破的最高楼 
 * 解： 
 * 第一种解法：当N=2时，
 * 我们第一次选择的K层在K层扔鸡蛋，那么破了我们最多要扔K次。不破的话我们为了在最坏的情况下将接下来要扔的次数最好等于K，
 * 我们接下来每次要扔的层数认为K-N-1(N为扔的总次数)，将此算法用公式F表达出来即为：
 * 最后一次没有破裂的层数 + K+(K-1)+(K-2)……+2+1=h,
 * 为了扔的次数最少，我们应将最后一次没有破解的层数靠近0，由此将上述公式F简化为：0 + K(K+1)/2=h
 * 第二种解法(动态规划)：f[n][h]=min(h,1+max(f[n-1][k-1],f[n][h-k]))
 * 解释下原理： 
 * a. 当手上只有1个蛋时，最坏情况下需要h层才可以测试得出
 * b. 当手里有n个的时候，第一个蛋从k层往下摔，如果破了，那么手里只有n-1蛋了，
 * 那么就需要测试f[n-1][k-1]楼层 ,那么当手里有2个蛋的时候,
 * 以上子式变为f[2][m] = 1+max(f[1][k-1],f[2][m-k]) （m为倒数第三个鸡蛋摔碎的楼层）
 * 如果在km层摔碎了。那么现在手里也就只有一个鸡蛋了，
 * 此时我们必须遍历1~km-1找出第一次碎的楼层。所以子式变化为1+f[1][m-km]
 * c. 没破，那么手里还有n个鸡蛋，那么只需要测试h-k-1这些楼层。 也就是说，此时我们将h替换为h-k-1就好了
 * 本文采用第二种，如有小伙胖有兴趣可以将第一种写法附加进来。
 * 
 * @author sq
 * @date 2020/05/29
 */
public class EggDownstair {
    
    /**
     * 最少多少求出鸡蛋摔破的楼层
     * 
     * @param n
     *            多少个鸡蛋
     * @param h
     *            多少楼
     * @return 最少多少次
     */
    public int countMinSetp(int n, int h) {
        if (n < 1 || h < 1) {
            return 0;
        }
        final int[][] f = new int[n + 1][h + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= h; j++) {
                f[i][j] = j;
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= h; j++) {
                for (int k = 1; k < j; k++) {
                    f[i][j] = Math.min(f[i][j],
                        1 + Math.max(f[i - 1][k - 1], f[i][j - k]));
                }
            }
        }
        return f[n][h];
    }
    
    public static void main(String[] args) {
        System.out.println(new EggDownstair().countMinSetp(3, 100));
    }

}
