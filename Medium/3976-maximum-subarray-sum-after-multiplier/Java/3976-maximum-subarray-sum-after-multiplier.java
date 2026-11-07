class Solution {

                public long helper(int[] arr, int k, boolean flag) {
                    long LIM = Long.MIN_VALUE / 4;

                    long d0 = arr[0];
                    long ans = helper2(arr[0], k, flag);
                    long d1 = ans;
                    long d2 = LIM;

                    long result = Math.max(d0, d1);

                    for(int i = 1; i<arr.length; i++) {
                        long a = arr[i];
                        long b = helper2(arr[i], k, flag);

                        long n2 = Math.max(d1+a, d2+a);
                        long n1 = Math.max(b, Math.max(d0+b, d1+b));

                        long n0 = Math.max(a, d0+a);

                        d0 = n0;
                        d1 = n1;
                        d2 = n2;

                        result = Math.max(result, Math.max(d0, Math.max(d1, d2)));
                    }

                    return result;
                }

    public long helper2(int a, int k, boolean flag) {
        if(flag) {
            return 1L * a * k;
            
        }
        return a/k;
    }
    public long maxSubarraySum(int[] nums, int k) {

        return Math.max(helper(nums, k, true), helper(nums, k, false));
        
    }
}