package problems;

import org.junit.Test;

/**
 * N字形变换
 */
public class p6_zigzag_conversion {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        // 找到向下和向上的步长规律
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int downStep = (numRows - i - 1) * 2;
            int upStep = i * 2;
            sb.append(s.charAt(i));
            if (downStep == 0 && upStep == 0)
                break;
            boolean down = true;
            for (int j = i + downStep; j < s.length(); j += down ? downStep : upStep) {
                if (down) {
                    down = false;
                    if (downStep == 0)
                        continue;
                } else {
                    down = true;
                    if (upStep == 0)
                        continue;
                }
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(convert("A", 1));
    }
}