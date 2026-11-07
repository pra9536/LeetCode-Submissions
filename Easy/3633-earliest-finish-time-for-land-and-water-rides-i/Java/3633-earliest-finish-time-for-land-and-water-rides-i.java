class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;

        int n = landStartTime.length;
        int m = waterStartTime.length;

        for(int i = 0; i<n; i++){
            int land = landStartTime[i] + landDuration[i];

            for(int j = 0; j<m; j++){
                int waterStart = waterStartTime[j];
                int waterFinish = waterStartTime[j] + waterDuration[j];

                int f1 = Math.max(land, waterStart) + waterDuration[j];

                int f2 = Math.max(waterFinish, landStartTime[i]) + landDuration[i];

                min = Math.min(min, Math.min(f1, f2));
            }
        }

        return min;
    }
}