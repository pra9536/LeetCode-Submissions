class Solution {
    static int parent[];
    static int size[];
    public int leader(int node) {
        if(parent[node] == node) return node;
        return parent[node] = leader(parent[node]);
    }
    public void union(int u, int v) {
        u = leader(u);
        v = leader(v);

        if(u != v) {
            if(size[u] > size[v]) {
                parent[v] = u;
                size[u] += size[v];
            } else {
                parent[u] = v;
                size[v] += size[u];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 1; i<=n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int []edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(leader(u) == leader(v)) {
                return new int[]{u, v};
            } else {
                union(u, v);
            }
        }


        return new int[]{};


    }
}