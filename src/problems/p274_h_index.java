package problems;

import java.util.Arrays;

import org.junit.Test;

/**
 * H指数
 */
public class p274_h_index {
    // 逆序搜索
    // 不好理解，用例子死记吧
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int H = 0;
        for (int i = citations.length - 1; i >= 0 && citations[i] > H; i--) {
            H++;
        }
        return H;
    }

    @Test
    public void test() {
        hIndex(new int[] { 3, 0, 6, 1, 5 });
    }
}