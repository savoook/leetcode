package leetCode.majorityElement;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest {
    private int[] array1 = new int[]{3, 2, 3};
    private int[] array2 = new int[]{2, 2, 1, 1, 1, 2, 2};

    @Test
    public void majorityElementTest() {
        assertEquals(new Solution().majorityElement(array1), 3);
        assertEquals(new Solution().majorityElement(array2), 2);
    }
}