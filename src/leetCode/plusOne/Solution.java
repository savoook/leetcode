package leetCode.plusOne;

// 9, 8, 9
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int j = 0; j < digits.length; j++) {
            res[j + 1] = digits[j];
        }
        return res;
    }
}
