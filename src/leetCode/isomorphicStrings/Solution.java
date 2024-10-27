package leetCode.isomorphicStrings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s_ = s.charAt(i);
            char t_ = t.charAt(i);
            if (map.containsKey(s_)) {
                if (map.get(s_) != t_) return false;
            }

            if (map.containsValue(t_)) {
                if (!map.containsKey(s_)) return false;
            }
            map.put(s_, t_);
        }
        return true;
    }
}