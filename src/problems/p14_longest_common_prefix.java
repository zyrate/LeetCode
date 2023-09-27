package problems;

/**
 * 最长公共前缀
 */
public class p14_longest_common_prefix {

    public String longestCommonPrefix(String[] strs) {
        int curr = 0;
        String target = strs[0]; // 拿第一个与后面的比较
        if (strs.length == 1) // 需要留意特殊情况
            return target;
        while (true) {
            boolean found = true;
            for (int i = 1; i < strs.length; i++) {
                if (curr == target.length() || curr == strs[i].length()
                        || strs[i].charAt(curr) != target.charAt(curr)) {
                    found = true;
                    break;
                }
                found = false;
            }
            if (found)
                break;
            curr++;
        }
        if (curr == 0)
            return "";
        return target.substring(0, curr);
    }

    // 尽量不用死循环
    // 看起来也简洁一点
    public String longestCommonPrefix02(String[] strs) {
        String target = strs[0];
        if (target.length() == 0) {
            return "";
        }
        int i, j;
        for (i = 0; i < target.length(); i++) {
            for (j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || target.charAt(i) != strs[j].charAt(i)) {
                    break;
                }
            }
            if (j != strs.length) {
                break;
            }
        }
        return target.substring(0, i);
    }
}