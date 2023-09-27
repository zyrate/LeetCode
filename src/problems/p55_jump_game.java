package problems;

import org.junit.Test;

/**
 * 跳跃游戏
 */
public class p55_jump_game {
    private boolean[] fails;

    public boolean canJump(int[] nums) {
        fails = new boolean[nums.length];
        return jump(nums, 0);
    }

    // 递归 - 时间复杂度太高
    private boolean jump(int[] nums, int curr) {
        if (curr >= nums.length)
            return false;
        if (curr == nums.length - 1)
            return true;
        int step = nums[curr];
        if (step == 0)
            return false;

        boolean flag = false;
        while (step > 0) {
            if (!jump(nums, curr + step)) {
                step--;
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Test
    public void test01() {
        boolean res = canJump(new int[] { 3, 2, 1, 0, 4 });
    }

    // 用标记数组去除冗余的情况
    // 还是有些慢
    private boolean jump02(int[] nums, int curr) {
        if (curr >= nums.length)
            return false;
        if (curr == nums.length - 1)
            return true;
        int step = nums[curr];
        if (step == 0)
            return false;
        if (fails[curr])
            return false;

        boolean flag = false;
        while (step > 0) {
            if (!jump(nums, curr + step)) {
                if (curr + step < nums.length) {
                    fails[curr + step] = true; // 标记失败的位置
                }
                step--;
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 贪心算法 - 记录当前最大可达位置，O(N)
     * @param nums
     * @return
     */
    public boolean canJump02(int[] nums) {
        int farest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farest)
                return false;
            if (farest < nums[i] + i) {
                farest = nums[i] + i;
            }
        }
        return true;
    }
}