package leetCode.intersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) intersection(nums2, nums1);
        Set<Integer> num = new HashSet<>();
        for (int i : nums1) num.add(i);
        Set<Integer> res = new HashSet<>();
        //List<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            if (num.contains(j)) {
                res.add(j);
                //   num.remove(j);
            }
        }
        int[] res1 = new int[res.size()];
        int i = 0;
//        for (int i = 0; i < res.size(); i++) {
//            res1[i] = res.get(i);
//        }
        for (Integer n : res) {

            res1[i++] = n;
        }
        return res1;//res.stream().mapToInt(Integer::intValue).toArray();
    }
}
