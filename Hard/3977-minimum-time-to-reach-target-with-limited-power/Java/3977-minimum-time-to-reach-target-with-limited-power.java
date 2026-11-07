class Solution {

    static class Edge {
        int dest;
        long period;

        Edge(int dest, long period) {
            this.dest = dest;
            this.period = period;
        }
    }

    static class State {
        int n;
        int l;
        long period;

        State(int n, int l, long period) {
            this.n = n;
            this.l = l;
            this.period = period;
        }
    }
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        if(source == target) {
            return new long[]{0, power};
        }

        List<Edge>[] g = new ArrayList[n];
        for(int i = 0; i<n; i++){
            g[i] = new ArrayList<>();
        }

        for(int []e : edges) {
            int a = e[0];
            int b = e[1];
            int c = e[2];

            g[a].add(new Edge(b, c));
        }

        long[][] d = new long[n][power+1];

        for(int i = 0; i<n; i++){
            Arrays.fill(d[i], Long.MAX_VALUE);
        }

        d[source][power] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((x, y) -> {
            if(x.period != y.period) {
                return Long.compare(x.period, y.period);
            }

            return Integer.compare(y.l, x.l);
        });

        pq.offer(new State(source, power, 0));

        long bestPeriod = Long.MAX_VALUE;
        long bestP = -1;

        while(!pq.isEmpty()) {
            State st = pq.poll();
            int a = st.n;
            int b = st.l;
            long c = st.period;

            if(c > d[a][b]) {
                continue;
            }

            if(a == target) {
                if(bestPeriod == Long.MAX_VALUE) {
                    bestPeriod = c;
                }

                if(c > bestPeriod) {
                    break;
                }

                bestP = Math.max(bestP, b);
                continue;
            }

            if(b < cost[a]) {
                continue;
            }

            int nextP = b - cost[a];

            for(Edge e : g[a]) {
                int m = e.dest;
                long newPeriod = c + e.period;

                if(newPeriod < d[m][nextP]) {
                    d[m][nextP] = newPeriod;
                    pq.offer(new State(m, nextP, newPeriod));
                }
            }
        }
        if(bestPeriod == Long.MAX_VALUE) {
            return new long[]{-1, -1};
        }

        return new long[]{bestPeriod, bestP};
    }
}