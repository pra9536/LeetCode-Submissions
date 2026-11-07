class Solution {

    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numEnclaves(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();

        int m = grid.length; 
        int n = grid[0].length;

        for(int j = 0; j<n; j++){
            if(grid[0][j] == 1) {
                grid[0][j] = -1;
                queue.add(new Pair(0, j));
            }

            if(grid[m-1][j] == 1) {
                grid[m-1][j] = -1;
                queue.add(new Pair(m-1, j));
            }
        }

        for(int i = 0; i<m; i++){
            if(grid[i][0] == 1) {
                grid[i][0] = -1;
                queue.add(new Pair(i, 0));
            }
            if(grid[i][n-1] == 1) {
                grid[i][n-1] = -1;
                queue.add(new Pair(i, n-1));
            }
        }

       

        while(queue.size() > 0) {
            Pair p = queue.remove();
            int row = p.row;
            int col = p.col;

            if(col-1 >= 0 && grid[row][col-1] == 1) {
                grid[row][col-1] =-1;
                queue.add(new Pair(row, col-1));
            }
            if(col+1 < n && grid[row][col+1] == 1) {
                grid[row][col+1] =-1;
                queue.add(new Pair(row, col+1));
            }
            if(row-1 >= 0 && grid[row-1][col] == 1) {
                grid[row-1][col] =-1;
                queue.add(new Pair(row-1, col));
            }
            if(row+1 < m && grid[row+1][col] == 1) {
                grid[row+1][col] =-1;
                queue.add(new Pair(row+1, col));
            }

        }

        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;


    }
}