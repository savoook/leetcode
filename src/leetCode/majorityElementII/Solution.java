package leetCode.majorityElementII;

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 1) return Collections.singletonList(nums[0]);
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> res = new HashSet<>();
        int length = nums.length;
        for (int n : nums) {
            if (/*map.containsKey(n) &&*/ map.getOrDefault(n, 0) + 1 > nums.length / 3) res.add(n);
            else map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return new ArrayList<>(res);
    }
}
