// class Solution {
//     int totalSum = Integer.MAX_VALUE;
//     public int helper(int[][]grid, int i, int j, int sum, int[][] dp) {
//         if(i >= grid.length || j >= grid[0].length) return sum;
//         if(i == grid.length - 1 && j == grid[0].length-1) {
//             sum += grid[i][j];
//             totalSum = Math.min(totalSum, sum);
//             return totalSum;
//         }
//         if(dp[i][j] != -1) return dp[i][j];
//         return dp[i][j] = Math.min(helper(grid, i, j + 1, sum + grid[i][j], dp), helper(grid, i+1, j, sum + grid[i][j], dp));
//     }
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int dp[][] = new int[m][n];
//         for(int []num : dp) {
//             Arrays.fill(num, -1);
//         }
//         helper(grid, 0, 0, 0, dp);
//         return totalSum;
//     }
// }


class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
       for(int i = 0; i<m; i++) {
        for(int j = 0; j<n; j++) {
            if(i == 0 && j == 0) continue;
            if(i == 0) grid[i][j] = grid[i][j] + grid[i][j-1];
            else if(j == 0) grid[i][j] = grid[i-1][j] + grid[i][j];
            else {
                grid[i][j] = grid[i][j] + Math.min( grid[i-1][j], grid[i][j-1]);
            }
        }
       }
       return grid[m-1][n-1];
    }
}