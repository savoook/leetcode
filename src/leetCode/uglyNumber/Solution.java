package leetCode.uglyNumber;

class Solution {
    //1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
}