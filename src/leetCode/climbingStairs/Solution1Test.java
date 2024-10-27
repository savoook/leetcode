package leetCode.climbingStairs;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class Solution1Test {

    @BeforeClass
    public static void init() {
        Solution solution = new Solution();
        Solution1 solution1 = new Solution1();
    }

    @Test
    @Ignore
    public void testSolution() {
        assertEquals(new Solution().climbStairs(2), 2);
        assertEquals(new Solution().climbStairs(3), 3);
        assertEquals(new Solution().climbStairs(9), 55);
    }

    @Test
    public void testSolution1() {
        assertEquals(new Solution1().climbStairs(2), 2);
        assertEquals(new Solution1().climbStairs(3), 3);
        assertEquals(new Solution1().climbStairs(9), 55);
    }
}