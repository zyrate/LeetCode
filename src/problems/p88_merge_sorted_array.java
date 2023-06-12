package problems;
/**
 * 不需要新建一个数组，用逆向双指针法即可
 */
public class p88_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = nums1;
        int ptr1 = m-1, ptr2 = n-1, k = m+n-1;
        while(ptr1 >= 0 && ptr2 >= 0){
            if(nums1[ptr1] > nums2[ptr2]){
                res[k--] = nums1[ptr1--];
            }else{
                res[k--] = nums2[ptr2--];
            }
        }
        while(ptr1 >= 0) res[k--] = nums1[ptr1--];
        while(ptr2 >= 0) res[k--] = nums2[ptr2--];
    }

    public static void test(){
        int nums1[] = new int[]{1,4,5,0,0,0};
        int nums2[] = new int[]{1,2,3};
        new p88_merge_sorted_array().merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.println(num);
        }
    }
}
