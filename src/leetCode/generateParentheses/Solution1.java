package leetCode.generateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    private void generate(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }
        if (open < max) generate(res, cur + "(", open + 1, close, max);
        if (close < open) generate(res, cur + ")", open, close + 1, max);
    }
}
