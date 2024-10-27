package leetCode.uglyNumberII;

class Solution {
    //0  1  2  3  4  5  6  7  8   9   10
    //1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int pointer2 = 0;
        int pointer3 = 0;
        int pointer5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(2 * ugly[pointer2], Math.min(3 * ugly[pointer3], 5 * ugly[pointer5]));
            if (ugly[i] == 2 * ugly[pointer2]) pointer2++;
            if (ugly[i] == 3 * ugly[pointer3]) pointer3++;
            if (ugly[i] == 5 * ugly[pointer5]) pointer5++;
        }
        return ugly[n - 1];
    }
}