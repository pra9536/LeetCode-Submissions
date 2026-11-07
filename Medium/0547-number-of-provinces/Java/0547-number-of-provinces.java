class Solution {

    public void bfs(boolean[] visited, int node, int [][]isConnected) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            int val = q.remove();

            for(int i = 0; i<isConnected[val].length; i++) {
                if(isConnected[val][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       int count = 0;
       boolean []visited = new boolean[isConnected.length];

       for(int i = 0; i<isConnected.length; i++) {
        if(!visited[i]) {
            bfs(visited, i, isConnected);
            count++;
        }
       }
       return count;



    }
}