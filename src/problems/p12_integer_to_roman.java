package problems;

/**
 * 整数转罗马数字
 */
public class p12_integer_to_roman {
    public String intToRoman(int num) {
        int[] bits = new int[4];
        String roman = "";
        // 个十百千四位从低到高拿出来
        for (int i = 0; num > 0; i++) {
            bits[i] = num % 10;
            num /= 10;
        }
        // 从高到低遍历
        for (int i = bits.length - 1; i >= 0; i--) {
            switch (i) {
                case 3:
                    roman += transBit(bits[i], "M", "", "");
                    break;
                case 2:
                    roman += transBit(bits[i], "C", "D", "M");
                    break;
                case 1:
                    roman += transBit(bits[i], "X", "L", "C");
                    break;
                case 0:
                    roman += transBit(bits[i], "I", "V", "X");
                    break;
            }
        }
        return roman;
    }

    // 每个区间的逻辑是一样的（低、中、高）
    private String transBit(int bit, String low, String mid, String high) {
        String roman = "";
        if (bit < 4) {
            while (bit-- != 0)
                roman += low;
        } else if (bit == 4) {
            roman = low + mid;
        } else if (bit < 9) {
            roman = mid;
            bit -= 5;
            while (bit-- != 0)
                roman += low;
        } else if (bit == 9) {
            roman = low + high;
        }
        return roman;
    }
}