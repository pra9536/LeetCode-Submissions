class Solution {

    class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();

        for(int i = 0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            list.get(u).add(new Pair(v, w));
        }

        int []cost = new int[n+1];

        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[k] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

        q.add(new Pair(k, 0));

        while(!q.isEmpty()) {
            Pair top = q.remove();

            int topNode = top.node;
            int topTime = top.time;

            if(topTime > cost[topNode]) continue;

            for(int i = 0; i<list.get(topNode).size(); i++) {
                int currNode = list.get(topNode).get(i).node;
                int currTime = list.get(topNode).get(i).time;

                if((currTime + topTime) < cost[currNode]) {
                    cost[currNode] = currTime + topTime;
                    q.add(new Pair(currNode, cost[currNode]));
                }
            }
        }

        int max = 0;

        for(int i = 1; i<=n; i++) {
         if(cost[i] == Integer.MAX_VALUE) return -1;
         max = Math.max(max, cost[i]);
        }

        return max;
    }
}