package problems;
/**
 * 双指针法 - 空位思想
 */
public class p27_remove_element {
    public int removeElement(int[] nums, int val) {
        int emptyIndex = 0, next = 0;
        while(next < nums.length){
            if(nums[next] != val){
                nums[emptyIndex] = nums[next];
                emptyIndex++;
            }
            next++;
        }
        return emptyIndex;
    }
}
