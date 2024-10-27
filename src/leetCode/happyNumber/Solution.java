package leetCode.happyNumber;

import java.util.HashSet;
import java.util.Set;

//19
class Solution {
    public boolean isHappy(int n) {
        if (n < 1) return false;
        int num = n;
        Set<Integer> result = new HashSet<>();
        while (!result.contains(num)) {
            result.add(num);
            num = digitSquareSum(num);
        }
        return num == 1;
    }

    private int digitSquareSum(int n) {
        int res = 0;
        int digit;
        for (; n > 0; n /= 10) {
            digit = n % 10;
            res += digit * digit;
        }
        return res;
    }
}
