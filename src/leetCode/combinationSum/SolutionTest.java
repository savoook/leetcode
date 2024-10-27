package leetCode.combinationSum;

import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

class SolutionTest {

    @Test
    public void combinationSumTest() {
        assertEquals(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7),
                asList(asList(2, 2, 3), Collections.singletonList(7)));
        assertEquals(new Solution().combinationSum(new int[]{2, 3, 5}, 8),
                asList(asList(2, 2, 2, 2), asList(2, 3, 3), asList(3, 5)));
        assertEquals(new Solution().combinationSum(new int[]{2}, 1), Collections.EMPTY_LIST);
    }
}