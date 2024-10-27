package leetCode.TreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int newTarget = target - nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (lo > i + 1 && nums[lo] == nums[lo - 1]) {
                    lo++;
                    continue;
                }
                if (hi < nums.length - 1 && nums[hi] == nums[hi + 1]) {
                    hi--;
                    continue;
                }
                int sum = nums[lo]+nums[hi];
                if (sum<newTarget){
                    lo++;
                }else if(sum>newTarget){
                    hi--;
                }else{
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                }
            }
        }
        return result;
    }
}
