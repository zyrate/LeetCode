package problems;

/**
 * 反转字符串中的单词
 */
public class p151_reverse_words_in_a_string {
    /**
     * 双指针法
     * 
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = s.length() - 1, end = s.length() - 1;
        while (start >= 0 || start < end) {
            if (s.charAt(end) == ' ') {
                start--;
                end--;
            } else if (start >= 0 && s.charAt(start) != ' ') {
                start--;
            } else if (start < 0 || s.charAt(start) == ' ') {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(s.substring(start + 1, end + 1));
                end = start;
            }
        }
        return sb.toString();
    }
}