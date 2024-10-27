package leetCode.firstBadVersion;

import org.junit.Test;

import static org.junit.Assert.*;

class SolutionTest {

    @Test
    public void firstBadVersion() {
        assertEquals(new Solution().firstBadVersion(8), 2);
        assertEquals(new Solution().firstBadVersion(1), 1);
    }
}