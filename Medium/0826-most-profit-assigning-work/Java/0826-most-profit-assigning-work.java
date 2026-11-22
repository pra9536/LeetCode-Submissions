class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int count = 0;

        for(int i = 0; i<worker.length; i++) {
            int max = 0;
            for(int j = 0; j<difficulty.length; j++) {
                if(difficulty[j] <= worker[i]) {
                    max = Math.max(max, profit[j]);
                }
            }
            count += max;
        }

        return count;
    }
}