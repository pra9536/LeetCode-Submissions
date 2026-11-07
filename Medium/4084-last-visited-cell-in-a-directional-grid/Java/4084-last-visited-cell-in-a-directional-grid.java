class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int []ans = new int[2];

        int row = 0;
        int col = 0;

        while(true) {
            char ch = grid[row][col];
                grid[row][col] = 'N';
                if(ch == 'R') {
                    col = col+1;
                    if(col >= n || grid[row][col] == 'N') return new int[]{row, col-1};
                }
                else if(ch == 'L') {
                    col = col - 1;
                    if(col < 0 || grid[row][col] == 'N') return new int[]{row, col+1};
                }
                else if(ch == 'U') {
                    row = row - 1;
                    if(row < 0 || grid[row][col] == 'N') return new int[]{row+1, col};
                }
                else if(ch == 'D') {
                    row = row + 1;
                    if(row >= m || grid[row][col] == 'N') return new int[]{row-1, col};
                }
        }
    }
}