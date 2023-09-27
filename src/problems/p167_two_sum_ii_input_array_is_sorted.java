package problems;

/**
 * 两数之和 II - 输入有序数组
 */
public class p167_two_sum_ii_input_array_is_sorted {
    /**
     * 暴力
     * 
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = 1;
        while (left < numbers.length) {
            right = left + 1;
            while (right < numbers.length) {
                if (numbers[left] + numbers[right] == target) {
                    return new int[] { left + 1, right + 1 };
                }
                right++;
            }
            left++;
        }
        return null;
    }
}