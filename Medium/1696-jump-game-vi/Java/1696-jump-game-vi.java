class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        int []dp = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();

        int ans = Integer.MIN_VALUE;

        dq.offerLast(0);
        dp[0] = nums[0];

        for(int i = 1; i<n; i++) {
            while(!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.removeFirst();
            }

            int best = dp[dq.peekFirst()];

            dp[i] = best + nums[i];

            ans = Math.max(ans, dp[i]);

            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }
        return dp[n-1];
    }
}