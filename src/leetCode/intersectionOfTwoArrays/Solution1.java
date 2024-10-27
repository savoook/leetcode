package leetCode.intersectionOfTwoArrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setNum2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(setNum2::contains).toArray();
    }
}
