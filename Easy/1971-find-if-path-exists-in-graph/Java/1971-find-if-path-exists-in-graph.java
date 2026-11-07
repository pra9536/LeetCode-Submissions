class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == destination) return true;
        // create adjacency list

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            list.add(new ArrayList<>());
        }

        for(int []edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();

        boolean []visited = new boolean[list.size()];

        q.add(source);

        visited[source] = true;

        while(!q.isEmpty()) {
            int val = q.remove();

            for(int i = 0; i<list.get(val).size(); i++) {
                if(destination == list.get(val).get(i)) return true;
                if(!visited[list.get(val).get(i)]) {
                    visited[list.get(val).get(i)] = true;
                    q.add(list.get(val).get(i));
                }
            }
        }
        return false;


    }
}