package leetCode.summaryRanges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//[0,2,3,4,6,8,9]
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i + 1] == nums[i] + 1) continue;
            result.add(j != i ? String.format("%d->%d", nums[j], nums[i]) : String.valueOf(nums[i]));
            j = i + 1;
        }
        return result;
    }
}