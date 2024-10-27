package leetCode.missingNumber;

import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0]!=0) return 0;
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - begin > 1) return nums[i] - 1;
            begin = nums[i];
        }
        return nums[nums.length - 1] + 1;
    }
}
