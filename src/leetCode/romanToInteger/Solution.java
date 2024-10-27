package leetCode.romanToInteger;

import java.util.HashMap;
import java.util.Map;
//Input:s="MCMXCIV"
//Output:1994
//Explanation:M=1000,CM=900,XC=90 and IV=4.

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && map.get(chars[i]) > map.get(chars[i-1])) {
                result += map.get(chars[i]) - 2 * map.get(chars[i - 1]);
            } else {
                result += map.get(chars[i]);
            }
        }
        return result;
    }
}
