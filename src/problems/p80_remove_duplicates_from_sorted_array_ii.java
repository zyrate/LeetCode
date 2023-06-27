package problems;

import org.junit.Test;

import common.Utils;

/**
 * 用我自己的空位思想的话，要注意cnt的取值及判断，这是“向后检查”的思想，效率不高，很绕
 */
public class p80_remove_duplicates_from_sorted_array_ii {
    public int removeDuplicates(int[] nums) {
        int emptyIndex = 1, ptr = 0, next = 1;
        int cnt = 1;
        while(next < nums.length){
            if(nums[next] != nums[ptr]){
                nums[emptyIndex] = nums[next];
                ptr = emptyIndex;
                emptyIndex++;
                cnt = 1;
            }else{
                if(cnt < 3){
                    nums[emptyIndex] = nums[next];
                    emptyIndex++;
                }
                cnt++;
            }
            next++;
        }
        return emptyIndex;
    }

    /**
     * 快慢指针的思想，采用“向前检查”，简便易懂
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums){
        int slow = 2, fast = 2; // 这里slow就代表下一个空位了
        while(fast < nums.length){
            if(nums[slow-2] != nums[fast]){ // 只要fast的和slow之前两个的不相同，则fast位置一定保留
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    @Test
    public void test(){
        int[] nums = {1,1,1,1,1,2,2,2,2,2,3};
        removeDuplicates2(nums);
        Utils.printArray(nums);
    }
}
