package leetCode.nextGreaterElementI;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

class SolutionTest {
    private final int[] nums1 = {4, 1, 2};
    private final int[] nums2 = {1, 3, 4, 2};

    @Test
    public void nextGreaterElementTest() {
        assertArrayEquals(new Solution().nextGreaterElement(nums1, nums2), new int[]{-1, 3, -1});
    }
}