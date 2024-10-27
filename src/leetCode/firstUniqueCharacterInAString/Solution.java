package leetCode.firstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) map.put(cur, i);
            else map.put(cur, -1);
        }
        int min = Integer.MAX_VALUE;
        for (Character c : map.keySet()) {
            if (map.get(c) != -1 && map.get(c) < min) {
                min = map.get(c);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
