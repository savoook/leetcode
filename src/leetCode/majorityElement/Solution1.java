package leetCode.majorityElement;

import java.util.Arrays;

class Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
