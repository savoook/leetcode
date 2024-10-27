package leetCode.wordSearch;

class Solution {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == word.charAt(0) && search(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean search(char[][] board, int i, int j, int index, String word) {

        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j])
            return false;

        visited[i][j] = true;
        if (search(board, i + 1, j, index + 1, word) ||
                search(board, i - 1, j, index + 1, word) ||
                search(board, i, j + 1, index + 1, word) ||
                search(board, i, j - 1, index + 1, word)
        ) return true;

        visited[i][j] = false;
        return false;
    }
}
