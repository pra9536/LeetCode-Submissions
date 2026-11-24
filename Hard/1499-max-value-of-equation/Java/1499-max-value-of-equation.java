class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i<points.length; i++) {
            while(!dq.isEmpty() && Math.abs(points[dq.peekFirst()][0] - points[i][0]) > k) {
             dq.removeFirst();  
            }

            if(!dq.isEmpty()) {
                int idx = dq.peekFirst();
                int val = points[idx][1] - points[idx][0] + points[i][0] + points[i][1];  
                max = Math.max(max, val);
            }

            while(!dq.isEmpty() && points[dq.peekLast()][1] - points[dq.peekLast()][0] <= points[i][1] - points[i][0]) dq.pollLast();

            dq.offerLast(i);
        }

        return max;
    }
}