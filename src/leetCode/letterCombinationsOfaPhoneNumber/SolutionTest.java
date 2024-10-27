package leetCode.letterCombinationsOfaPhoneNumber;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

class SolutionTest {

    @Test
    public void letterCombinationsTest() {
        assertEquals(new Solution().letterCombinations("23"),
                List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assertEquals(new Solution().letterCombinations("2"),
                List.of("a","b","c"));
    }
}