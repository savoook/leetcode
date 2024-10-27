package leetCode.uniquePaths;

class Solution {
    int[][] array = new int[101][101];

    public int uniquePaths(int m, int n) {
        if (n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        if (array[m][n] == 0) {
            array[m][n] = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
        return array[m][n];
    }
}
