package leetCode.palindromeNumber;

//-1221
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false;
        int basic = x;
        int reverse = 0;
        while (x != 0) {
            reverse = 10 * reverse + x % 10;
            x /= 10;
        }
        return basic == reverse;
    }
}
