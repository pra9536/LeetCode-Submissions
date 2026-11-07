class Pair{
    int x;
    int y;
    int dist;
    public Pair(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    // @Override
    // public int compareTo(Pair o){
    //     return this.dist - o.dist;
    // }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.dist - a.dist);
        for(int i = 0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            pq.add(new Pair(x, y, dist));
            if(pq.size() > k) pq.remove();
        }
        int ans[][] = new int[k][2];
        for(int i = 0; i<ans.length; i++){
            Pair p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
}