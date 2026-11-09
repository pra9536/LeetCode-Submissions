class Solution {
    public boolean isBipartite(int[][] graph) {

        for(int i = 0; i<graph.length; i++) {
        Queue<Integer> q = new LinkedList<>();
        int []color = new int[graph.length];
        Arrays.fill(color, -1);
        q.add(i);
        color[i] = 0;

        while(!q.isEmpty()) {
            int node = q.remove();
            int c = color[node];

            for(int j = 0; j<graph[node].length; j++) {
                int curr = graph[node][j];

                if(color[curr] == c) return false;

                if(color[curr] == -1) {
                    color[curr] = (c == 0) ? 1 : 0;
                    q.add(curr);
                }
            }
        }
        }
        return true;
    }
}