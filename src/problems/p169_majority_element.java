package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求大多数元素
 */
public class p169_majority_element {
    /**
     * 第一层解法，低效
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap(nums.length);
        for(int n:nums){
            int old = map.get(n) == null ? 0 : map.get(n);
            if(old+1 > nums.length/2) return n;
            map.put(n, old+1);
        }
        return 0;
    }

    /**
     * 大气层解法 - 牛逼
     * 摩尔投票法，抵消思想，不定量只定性
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int currNum = nums[0], cnt = 1;
        for(int n:nums){
            if(currNum == n){
                cnt++;
            }else{
                cnt--;
                if(cnt == 0){
                    currNum = n;
                    cnt = 1;
                }
            }
        }
        return currNum;
    }

    /**
     * 排序法 - 简洁
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length >> 1];  // 除以2用 >>1 加快运算
    }


}
