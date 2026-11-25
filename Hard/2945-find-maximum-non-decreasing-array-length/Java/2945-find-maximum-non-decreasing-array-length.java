class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;

        long prefix[] = new long[n+1];

        for(int i = 1; i<=n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        int groups[] = new int[n+1];
        int last[] = new int[n+2];

        for(int i = 1; i<=n; i++) {
            last[i] = Math.max(last[i], last[i-1]);
            groups[i] = groups[last[i]] + 1;

            long target = 2 * prefix[i] - prefix[last[i]];

            int j = Arrays.binarySearch(prefix, target);

            if(j < 0) j = -j-1;

            last[j] = i;
        }

        return groups[n];
    }
}