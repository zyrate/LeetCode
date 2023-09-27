package problems;

/**
 * 跳跃游戏 II
 */
public class p45_jump_game_ii {
    // 逆向贪心
    public int jump(int[] nums) {
        // 向前跳跃，向后遍历
        int step = 0;
        int backward = nums.length - 1;
        while (backward > 0) {
            for (int i = 0; i < backward; i++) {
                if (nums[i] + i >= backward) {
                    backward = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    // 正向贪心
    public int jump02(int[] nums) {
        int farest = 0;
        int step = 0;
        int end = 0; // 当前跳跃边界
        for (int i = 0; i < nums.length - 1; i++) {
            if (farest < nums[i] + i) {
                farest = nums[i] + i;
            }
            if (i == end) { // 到达边界，跳跃+1
                end = farest;
                step++;
            }
        }
        return step;
    }
}