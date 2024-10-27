package leetCode.isomorphicStrings;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SolutionTest {

    @Test
    public void isIsomorphicTest() {

        assertThat(new Solution().isIsomorphic("egg", "add")).isTrue();
        assertThat(new Solution().isIsomorphic("foo", "bar")).isFalse();
        assertThat(new Solution().isIsomorphic("paper", "title")).isTrue();

        assertThat(new Solution1().isIsomorphic("egg", "add")).isTrue();
        assertThat(new Solution1().isIsomorphic("foo", "bar")).isFalse();
        assertThat(new Solution1().isIsomorphic("paper", "title")).isTrue();
    }
}