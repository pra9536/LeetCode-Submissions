class Solution {

    class Pair{
        int node;
        int parent;
        int dist;

        Pair(int node, int parent, int dist) {
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for(int i = 0; i<points.length; i++) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int j = 0; j<points.length; j++) {
                
                if(j == i) continue;
                
                int dx = Math.abs(points[j][0] - points[i][0]);
                int dy = Math.abs(points[j][1] - points[i][1]);

                int dist = dx + dy;
                ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(dist);
                    list.add(temp);
            }
            adj.add(list);
        }


        boolean []visited = new boolean[points.length];

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        q.add(new Pair(0, -1, 0));

        int sum = 0;

        while(!q.isEmpty()) {
            Pair top = q.remove();

            int topCurr = top.node;
            int topParent = top.parent;
            int topWeight = top.dist;

            if(visited[topCurr]) continue;

            sum += topWeight;

            visited[topCurr] = true;

            for(int i = 0; i<adj.get(topCurr).size(); i++) {
                int curr = adj.get(topCurr).get(i).get(0);
                int weight = adj.get(topCurr).get(i).get(1);

                if(!visited[curr]) 
                q.add(new Pair(curr, topCurr, weight));
            }
        }

        return sum;

        
    }
}