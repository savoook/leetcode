package leetCode.validSudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] column = new boolean[9][9];
        boolean[][] row = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int nums = board[i][j] - '0' - 1;
                    int k = i / 3 * 3 + j / 3;
                    if (column[j][nums] || row[i][nums] || box[k][nums]) {
                        return false;
                    }
                    column[j][nums] = row[i][nums] = box[k][nums] = true;
                }
            }
        }
        return true;
    }
}

