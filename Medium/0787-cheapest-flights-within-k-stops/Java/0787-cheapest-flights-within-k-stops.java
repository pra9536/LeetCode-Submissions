class Solution {
    class Pair {
        int next;
        int price;
        int stop;

        Pair(int next, int price, int stop) {
            this.next = next;
            this.price = price;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int price = flights[i][2];
            list.get(u).add(new Pair(v, price, 0));
        }

        int []stops = new int[n];

        Arrays.fill(stops, Integer.MAX_VALUE);

        stops[src] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.price, b.price));

        q.add(new Pair(src, 0, 0));

        while(!q.isEmpty()) {
            Pair top = q.remove();

            int curr = top.next;
            int price = top.price;
            int stop = top.stop;

            if(curr == dst) return price;

            if(stop > stops[curr]) continue;

            stops[curr] = stop;

            if(stop > k) continue;

            for(int i = 0; i<list.get(curr).size(); i++) {
                int nt = list.get(curr).get(i).next;
                int p = list.get(curr).get(i).price;
                int s = list.get(curr).get(i).stop;

                    q.add(new Pair(nt, price + p, stop+1));
                
            }
        }

        return -1;
     }
}