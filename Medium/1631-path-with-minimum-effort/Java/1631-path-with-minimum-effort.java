class Solution {
    class Pair {
        int x;
        int y;
        int diff;

        Pair(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        ArrayList<ArrayList<ArrayList<Pair>>> list = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        for(int i = 0; i<m; i++) {
            list.add(new ArrayList<>());
            for(int j = 0; j<n; j++) {
                list.get(i).add(new ArrayList<>());
            }
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                int curr = heights[i][j];
                if((j+1) < n) {
                    list.get(i).get(j).add(new Pair(i, j+1, Math.abs(curr - heights[i][j+1])));
                }
                if(((i+1) < m)) {
                    list.get(i).get(j).add(new Pair(i+1, j, Math.abs(curr - heights[i+1][j])));
                }
                if((j-1) >= 0) {
                    list.get(i).get(j).add(new Pair(i, j-1, Math.abs(curr - heights[i][j-1])));
                }
                if((i-1) >= 0) {
                    list.get(i).get(j).add(new Pair(i-1, j, Math.abs(curr - heights[i-1][j])));
                }
            }
        }

        int [][]diff = new int[m][n];

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                diff[i][j] = Integer.MAX_VALUE;
            }
        }

        diff[0][0] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.diff, b.diff));

        q.add(new Pair(0, 0, 0));

        while(!q.isEmpty()) {
            Pair top = q.remove();

            int topX = top.x;
            int topY = top.y;
            int topDiff = top.diff;

            for(int i = 0; i<list.get(topX).get(topY).size(); i++) {
                int x = list.get(topX).get(topY).get(i).x;
                int y = list.get(topX).get(topY).get(i).y;
                int d = list.get(topX).get(topY).get(i).diff;

                if(diff[x][y] > Math.max(topDiff, d)) {
                    diff[x][y] = Math.max(topDiff, d);
                    q.add(new Pair(x, y, Math.max(topDiff, d)));
                }
                
            }
        }
        
        return diff[m-1][n-1];
    }
}   