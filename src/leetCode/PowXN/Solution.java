package leetCode.PowXN;

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }
        double res = 1;
        double current = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) res = res * current;
            current*=current;
        }
        return res;
    }
}