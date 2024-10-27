package leetCode.generateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) res.add("");
        else {
            for (int i = 0; i < n; i++)
                for (String left : generateParenthesis(i))
                    for (String right : generateParenthesis(n - i - 1))
                        res.add("(" + left + ")" + right);
        }
        return res;
    }
}
