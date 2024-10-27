package leetCode.validBoomerang;

class Solution {
    public boolean isBoomerang(int[][] points) {
        int c = points[0][0] * points[1][1] - points[1][0] * points[0][1];
        int y = points[0][1] - points[1][1];
        int x = points[0][0] - points[1][0];
        if (points[2][1] * x == points[2][0] * y + c) {
            return false;
        } else {
            return true;
        }
    }
}
