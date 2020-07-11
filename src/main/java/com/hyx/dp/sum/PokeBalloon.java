package com.hyx.dp.sum;

/**
 * 戳气球
 * 问：给定一个气球数组a，每次可以选择打破一个气球i，打破后获得a[i]*a[i-1]*a[i+1]元钱，求最大可以获得多少钱？a[-1] = 1,a[a.length] = 1
 * 
 * @author sq
 * @date 2020/07/10
 */
public class PokeBalloon {
    
    /**
     * 获取最大可以获得多少钱
     * 
     * @param arrays
     *            要获取的气球数组
     * @return 最大多少钱
     */
    public int get(final int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        int max = 1;
        if (arrays.length < 3) {
            for (int i = 0, size = arrays.length; i < size; i++) {
                if (arrays[i] <= 0) {
                    return 0;
                }
                max *= arrays[i];
            }
            return max;
        }
        final int[] nums = new int[arrays.length + 2];
        System.arraycopy(arrays, 0, nums, 1, arrays.length);
        nums[0] = nums[arrays.length + 1] = 1;
        final int[][] dps = new int[arrays.length + 2][arrays.length + 2];
        for (int i = arrays.length; i > -1; i--) {
            for (int j = i + 1, jSize = arrays.length + 2; j < jSize; j++) {
                for (int k = i + 1; k < j; k++) {
                    dps[i][j] = Math.max(dps[i][j], dps[i][k] + dps[k][j] + nums[i] * nums[j] * nums[k]);
                }
            }
        }
        return dps[0][arrays.length + 1];
        //return this.getMax(new int[arrays.length + 2][arrays.length + 2], nums, 0, arrays.length + 1);
    }

    /**
     * 获取在某个区间内可以获得的最大金额
     * 
     * @param memos
     *            备忘录
     * @param nums
     *            区间数组
     * @param left
     *            起始点
     * @param right
     *            结束点
     * @return 最大金额
     */
    /*private int getMax(final int[][] memos, final int[] nums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (memos[left][right] > 0) {
            return memos[left][right];
        }
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] + this.getMax(memos, nums, left, i)
                + this.getMax(memos, nums, i, right)); 
        }
        memos[left][right] = ans;
        return ans;
    }*/
    
    public static void main(String[] args) {
        final PokeBalloon pokeBalloon = new PokeBalloon();
        System.out.println(pokeBalloon.get(new int[] {3, 1, 5, 8}));
    }

}
