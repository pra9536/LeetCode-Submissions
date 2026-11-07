class Solution {
    public int countDays(int days, int[][] meetings) {
        
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // List<int[]> list = new ArrayList<>();

        // list.add(meetings[0]);
        int count = 0;
        int max = meetings[0][1];

        for(int i = 1; i<meetings.length; i++){
            int prev[] = meetings[i-1];
            int curr[] = meetings[i];

            int s1 = prev[0];
            int e1 =  max;
            int s2 = curr[0];
            int e2 = curr[1];
            if(s2 > max) {
                count += s2 - e1 - 1;
            }
            max = Math.max(max, e2);
        }

        

        // for(int i = 1; i<list.size(); i++){
        //     int prev[] = list.get(i-1);
        //     int curr[] = list.get(i);

        //     count += curr[0] - prev[1] - 1;
        // }
        count += days - max;
        count += meetings[0][0] - 1;
        


        return count;


        // int [] day = new int[days+1];

        // for(int i = 0; i<meetings.length; i++){
        //     int curr[] = meetings[i];
        //     for(int j = curr[0]; j<=curr[1]; j++){
        //         day[j] = 1;
        //     }
        // }
        // int count = 0;
        // for(int i = 1; i<day.length; i++){
        //     if(day[i] != 1) count++;
        // }
        // return count;
    }
}