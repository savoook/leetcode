package leetCode.findTheDifference;

class Solution {
    public char findTheDifference(String s, String t) {
        char charCode = t.charAt(s.length());
        for (int i = 0; i < t.length()-1; i++) {
            charCode -= s.charAt(i);
            charCode += t.charAt(i);
        }
        return charCode;
    }
}
