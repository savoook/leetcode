package leetCode.isSubsequence;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class SolutionTest {

    @Test
    public void isSubsequenceTest() {
        assertTrue(new Solution().isSubsequence("abc", "ahbgdc"));
        assertFalse(new Solution().isSubsequence("axc", "ahbgdc"));
    }
}