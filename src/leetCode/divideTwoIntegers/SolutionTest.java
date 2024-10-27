package leetCode.divideTwoIntegers;

import org.junit.Test;

import static org.junit.Assert.*;

class SolutionTest {

    @Test
    public void divideTest() {
        assertEquals(new Solution().divide(10, 3), 3);
        assertEquals(new Solution().divide(7, -3), -2);
    }
}