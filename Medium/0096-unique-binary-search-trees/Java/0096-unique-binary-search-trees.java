class Solution {
    public int helper(int n) {
       if(n <= 1) return 1;
       
       int total = 0;
       
       for(int root = 1; root <= n; root++) {
        total += helper(root-1) * helper(n - root);
       }

       return total;
       
    }
    public int numTrees(int n) {
        
        return helper(n);
    }
}