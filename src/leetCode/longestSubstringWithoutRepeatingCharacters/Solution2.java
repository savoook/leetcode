package leetCode.longestSubstringWithoutRepeatingCharacters;

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int[] chars = new int[256];
        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(i, chars[s.charAt(j)]);
            length = Math.max(length, j - i + 1);
            chars[s.charAt(j)] = j + 1;
        }
        return length;
    }
}
