class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int temp[] = new int[n];

        int i = 0; 
        for(i = 0; i<n; i++) {
            int factI = items[i][0];

            for(int j = 0; j<n; j++){
                if(i==j) continue;

                int factJ = items[j][0];
                
                if(factJ % factI == 0)
                    temp[i]++;
                
            }
           
        }

        int dp[] = new int[budget+1];

        for(i = 0; i<n; i++){
            int price = items[i][1];
            int fact = temp[i];

            int []tempDP = Arrays.copyOf(dp, budget+1);

            for(int j = 0; j<=budget; j++){
                if(j + price <= budget) {
                    tempDP[j+price] = Math.max(tempDP[j+price], dp[j]+1+fact);
                }
            }
            for(int k = price; k<=budget; k++){
                tempDP[k] = Math.max(tempDP[k], tempDP[k-price]+1);
            }
            dp = tempDP;
        }
            int count = 0;

            for(int x : dp) {
                count = Math.max(count, x);
            }
            return count;
        
    }
}