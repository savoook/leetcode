package leetCode.majorityElement;

import java.util.HashMap;
import java.util.Map;

class SolutionFinal {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int n : nums) {
            if (map.containsKey(n) && map.get(n) + 1 > nums.length / 2) return n;
            else map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return -1;
    }
}
