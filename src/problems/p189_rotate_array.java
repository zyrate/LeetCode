package problems;

import org.junit.Test;

import common.Utils;

/**
 * 轮转数组
 */
public class p189_rotate_array {

    /**
     * 把新数组当作缓存，主要操作原数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // k有可能比len大
        int[] temp = new int[k];
        for(int i=len-k,j=0; i<len; i++,j++){
            temp[j] = nums[i];
        }
        for(int i=len-1; i-k>=0; i--){
            nums[i] = nums[i-k];
        }
        for(int i=0; i<k; i++){
            nums[i] = temp[i];
        }
    }

    /**
     * 把新数组当作结果数组，主要操作新数组，最后copy回去
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k){
        int len = nums.length;
        int[] temp = new int[len];
        for(int i=0; i<len; i++){
            temp[(i+k)%len] = nums[i]; // 既然怕覆盖，那就轮转到新数组
        }
        System.arraycopy(temp, 0, nums, 0, len); // 第一次知道有这个方法，原生C实现
    }

    /**
     * 三次翻转 - 空间O(1)
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        for(int i=0; i<len/2; i++){ // 先翻转[0, n-1]
            int temp = nums[i];
            nums[i] = nums[len-i-1];
            nums[len-i-1] = temp;
        }
        for(int i=0; i<k/2; i++){ // 再翻转[0, k-1]
            int temp = nums[i];
            nums[i] = nums[k-i-1];
            nums[k-i-1] = temp;
        }
        for(int i=k; i<(len-k)/2+k; i++){ // 最后翻转[k, n-1]
            int temp = nums[i];
            nums[i] = nums[len-i-1+k];
            nums[len-i-1+k] = temp;
        }
    }

    // 还有一个方法是“裴蜀定理跳转”，有点复杂
    
    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        rotate3(arr, 3);
        Utils.printArray(arr);
    }
}
