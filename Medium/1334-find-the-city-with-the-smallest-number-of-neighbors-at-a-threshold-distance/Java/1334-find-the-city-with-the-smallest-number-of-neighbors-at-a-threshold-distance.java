class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int [][]dist = new int[n][n];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(i != j) dist[i][j] = Integer.MAX_VALUE; 
            }
        }

        for(int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int k = 0; k<n; k++) {
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    
                    if((dist[i][k] + dist[k][j]) >= 0)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 0; i<n; i++) 
        {
            for(int j = 0; j<n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        int min = n;
        int ans = -1;
        for(int i = 0; i<n; i++) {
            int temp = 0;
            for(int j = 0; j<n; j++) {
              if(i == j) continue;
              if(dist[i][j] <= distanceThreshold) temp++;
            }
            
            if(i == 0) {
                min = temp;
                ans = i;
            }
            else if(temp <= min) {
                min = temp;
                ans = i;
            }
        }
        return ans;
    }
}