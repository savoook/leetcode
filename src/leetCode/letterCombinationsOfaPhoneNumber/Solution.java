package leetCode.letterCombinationsOfaPhoneNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private static final String[] LETTERS = {
            " ",     // 0
            "",      // 1
            "abc",   // 2
            "def",   // 3
            "ghi",   // 4
            "jkl",   // 5
            "mno",   // 6
            "pqrs", // 7
            "tuv",   // 8
            "wxyz"   // 9
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.EMPTY_LIST;
        List<String> res = new ArrayList<>();
        backtrack(digits, 0, "", res);
        return res;
    }

    private void backtrack(String digits, int start, String letters, List<String> res) {
        if (start == digits.length()) {
            res.add(letters);
            return;
        }
        String current = LETTERS[digits.charAt(start) - '0'];
        for (char c : current.toCharArray()) {
            backtrack(digits, start + 1, letters + c, res);
        }
    }
}
