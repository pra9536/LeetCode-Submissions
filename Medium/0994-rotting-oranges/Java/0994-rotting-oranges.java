class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;

        // Add all rotten oranges first
        // Count fresh oranges

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int count = 0;

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                Pair p = q.remove();

                int row = p.row;
                int col = p.col;

                if (row - 1 >= 0 &&
                    grid[row - 1][col] == 1 &&
                    !visited[row - 1][col]) {

                    q.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                    fresh--;
                }

                if (col - 1 >= 0 &&
                    grid[row][col - 1] == 1 &&
                    !visited[row][col - 1]) {

                    q.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                    fresh--;
                }

                if (col + 1 < n &&
                    grid[row][col + 1] == 1 &&
                    !visited[row][col + 1]) {

                    q.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                    fresh--;
                }

                if (row + 1 < m &&
                    grid[row + 1][col] == 1 &&
                    !visited[row + 1][col]) {

                    q.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                    fresh--;
                }
            }

            count++;
        }

        if (fresh > 0)
            return -1;

        return count;
    }
}