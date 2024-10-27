package leetCode.findTheDifference;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest {

    @Test
    public void findTheDifferenceTest() {
        assertEquals(new Solution().findTheDifference("abcefg", "abcdefg"), 'd');
        assertEquals(new Solution().findTheDifference("abcd", "abcde"), 'e');
        assertEquals(new Solution().findTheDifference("", "y"), 'y');
    }
}