class Solution {
    List<List<String>> ans = new ArrayList<>();
    boolean isSafe(int row, List<String> board, int col, int n) {
        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c = col;
        while (c >= 0) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            c--;
        }
        r = row;
        c = col;
        while (r < n && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r++;
            c--;
        }
        return true;
    }
    void solve(List<String> board, int n, int col) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, board, col, n)) {
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());
                solve(board, n, col + 1);
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        solve(board, n, 0);
        return ans;
    }
}