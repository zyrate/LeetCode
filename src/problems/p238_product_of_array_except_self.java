package problems;

import org.junit.Test;

/**
 * 除自身以外数组的乘积
 */
public class p238_product_of_array_except_self {

    /**
     * 其实可以用两次循环
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        // 前缀积、后缀积
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] answer = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                answer[i] = right[i + 1];
            } else if (i == nums.length - 1) {
                answer[i] = left[i - 1];
            } else {
                answer[i] = right[i + 1] * left[i - 1];
            }
        }
        return answer;
    }

    @Test
    public void test() {
        productExceptSelf(new int[] { 1, 2, 3, 4 });
    }

    /**
     * 用两次循环，一个辅助数组完成
     * 思路是让answer数组不闲置
     * @param nums
     * @return
     */
    public int[] productExceptSelf02(int[] nums) {
        int[] answer = new int[nums.length];
        int[] buffer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int left = answer[i - 1] * nums[i - 1];
            answer[i] = left;
        }
        buffer[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int right = buffer[i + 1] * nums[i + 1];
            buffer[i] = right;
            answer[i] *= right;
        }
        return answer;
    }

    @Test
    public void test02() {
        productExceptSelf02(new int[] { 1, 2, 3, 4 });
    }
}