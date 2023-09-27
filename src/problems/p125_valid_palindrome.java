package problems;

/**
 * 验证回文串
 */
public class p125_valid_palindrome {
    /**
     * 水题
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!isWordOrNum(leftChar)) {
                left++;
                continue;
            }
            if (!isWordOrNum(rightChar)) {
                right--;
                continue;
            }
            if (leftChar != rightChar) {
                break;
            }
            left++;
            right--;
        }
        return left >= right;
    }

    private boolean isWordOrNum(char ch) {
        if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z') {
            return true;
        }
        return false;
    }
}