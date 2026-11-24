class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        int []dp = new int[nums.length];

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length; i++) {

            while(!dq.isEmpty() && i - k > dq.peekFirst()) {
                dq.removeFirst();
            }



            int best = dq.isEmpty() ? 0 : Math.max(0, dp[dq.peekFirst()]);

            dp[i] = nums[i] + best;

            ans = Math.max(ans, dp[i]);

            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        
        }
        return ans;
    }
}