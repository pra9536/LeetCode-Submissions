class Solution {
    public void dfs(int row, int col, char[][] grid, boolean [][]visited) {

        visited[row][col] = true;

        if((col + 1) < grid[0].length && grid[row][col+1] == '1' && !visited[row][col+1]) 
        dfs(row, col+1, grid, visited);

        if((col - 1) >= 0 && grid[row][col-1] == '1' && !visited[row][col-1]) dfs(row, col-1, grid, visited);

        if((row + 1) < grid.length && grid[row+1][col] == '1' && !visited[row+1][col])
        dfs(row+1, col, grid, visited);

        if((row - 1) >= 0 && grid[row-1][col] == '1' && !visited[row-1][col]) dfs(row-1, col, grid, visited);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean [][]visited = new boolean[m][n];

        int count = 0;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return count;
    }
}