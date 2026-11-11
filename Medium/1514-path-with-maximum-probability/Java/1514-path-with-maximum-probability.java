class Solution {

    class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            list.get(u).add(new Pair(v, p));
            list.get(v).add(new Pair(u, p));
        }

        double []total = new double[n];

        total[start_node] = 1;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));

        q.add(new Pair(start_node, 1));

        while(!q.isEmpty()) {
            Pair top = q.remove();

            int topNode = top.node;
            double topProb = top.prob;

            if(topProb < total[topNode]) continue;

            for(int i = 0; i<list.get(topNode).size(); i++) {
                int currNode = list.get(topNode).get(i).node;
                double currProb = list.get(topNode).get(i).prob;

                if((currProb * topProb) > total[currNode]) {
                    total[currNode] = (currProb * topProb);
                    q.add(new Pair(currNode, total[currNode]));
                }
            }
        }


        return total[end_node];


    }
}