package leetCode.containsDuplicateII;

class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(k - i, 0); j < i; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
