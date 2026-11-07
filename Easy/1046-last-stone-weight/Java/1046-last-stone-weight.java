class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones) pq.add(num);
        while(pq.size() != 0 && pq.size() != 1){
          int y = pq.remove();
          int x = pq.remove();
          if(y != x){
            pq.add(y-x);
          }
        }
        if(pq.size() == 1) return pq.peek();
        return 0;
    }
}