// class Solution {
//     public int helper(int [][]grid, int i, int j, int m, int n, int [][]dp) {
//         if(i >= m || j >= n || grid[i][j] == 1) return 0;
//         if(i == m - 1 && j == n - 1) return 1;
//         if(dp[i][j] != -1) return dp[i][j];
//         return dp[i][j] = helper(grid, i + 1, j, m, n, dp) + helper(grid, i, j + 1, m, n, dp);
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int dp[][] = new int[m][n];
//         for(int i = 0; i<m; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return helper(obstacleGrid, 0, 0, m, n, dp);
//     }
// }


// class Solution {
//     public int helper(int [][]grid, int i, int j, int m, int n) {
//         if(i >= m || j >= n || grid[i][j] == 1) return 0;
//         if(i == m - 1 && j == n - 1) return 1;
//         return helper(grid, i + 1, j, m, n) + helper(grid, i, j + 1, m, n);
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         return helper(obstacleGrid, 0, 0, m, n);
//     }
// }


// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int dp[][] = new int[m][n];
//         if(obstacleGrid[0][0] == 1) return 0;
//         else dp[0][0] = 1;
//         for(int i = 0; i<m; i++) {
//             for(int j = 0; j<n; j++) {
//                if(i == 0 && j == 0) continue;
//                if(obstacleGrid[i][j] == 1){
//                 dp[i][j] = 0;
//                 continue;
//                }    
//                if(i > 0) {
//                 dp[i][j] += dp[i-1][j];
//                }
//                if(j > 0) {
//                 dp[i][j] += dp[i][j-1];
//                }
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
               if(obstacleGrid[i][j] == 1) {
                dp[j] = 0;
               } else if(j > 0) {
                dp[j] += dp[j-1];
               }
            }
        }
        return dp[n-1];
    }
}