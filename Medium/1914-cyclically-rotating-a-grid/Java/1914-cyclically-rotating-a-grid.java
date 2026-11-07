class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m/2, n/2);

        for(int layer = 0; layer < layers; layer++){
            int top = layer;
            int bottom = m-1-layer;
            int left = layer;
            int right = n-1-layer;

            ArrayList<Integer> list = new ArrayList<>();

             // top
            for(int j = left; j <= right; j++){
                list.add(grid[top][j]);
            }

            // right
            for(int i = top + 1; i < bottom; i++){
                list.add(grid[i][right]);
            }

            // bottom
            for(int j = right; j > left; j--){
                list.add(grid[bottom][j]);
            }

            // left
            for(int i = bottom; i > top; i--){
                list.add(grid[i][left]);
            }

            int rotate = k % list.size();

            Collections.reverse(list.subList(0, rotate));
            Collections.reverse(list.subList(rotate, list.size()));
            Collections.reverse(list.subList(0, list.size()));

            int idx = 0;

            // top
            for(int j = left; j <= right; j++){
                grid[top][j] = list.get(idx++);
            }

            // right
            for(int i = top + 1; i < bottom; i++){
                grid[i][right] = list.get(idx++);
            }

            // bottom
            for(int j = right; j > left; j--){
                grid[bottom][j] = list.get(idx++);
            }

            // left
            for(int i = bottom; i > top; i--){
                grid[i][left] = list.get(idx++);
            }

            list.clear();


        }

        return grid;
    }
}