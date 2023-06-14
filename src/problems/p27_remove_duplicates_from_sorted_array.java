package problems;
/**
 * 三指针法 - 空位思想
 */
public class p27_remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        int emptyIndex = 1, ptr = 0, next = 1;
        while(next < nums.length){
            if(nums[next] != nums[ptr]){
                nums[emptyIndex] = nums[next];
                emptyIndex++;
                ptr++;
            }
            next++;
        }
        return emptyIndex;
    }
}
