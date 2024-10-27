package leetCode.repeatedSubstringPattern;

class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) < s.length();
    }
}
