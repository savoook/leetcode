package leetCode.FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

// 4,  3,  2,  7, 8, 2,  3,  1
//-4, -3, -2, -7, 8, 2, -3, -1
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            nums[curr - 1] = -(Math.abs(nums[curr - 1]));
        }
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) if (nums[j] > 0) res.add(j + 1);
        return res;
    }
}
