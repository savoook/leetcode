package leetCode.longestCommonPrefix;

import java.util.Arrays;

class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        String r = "";
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                r = r + first.charAt(i);
            } else {
                break;
            }
        }
        return r;
    }
}
