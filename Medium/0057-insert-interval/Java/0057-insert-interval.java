class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
    
         int left = 0;
         int right = 0;

         List<int[]> list = new ArrayList<>();

         while(left < intervals.length && intervals[left][1] < newInterval[0]){
            list.add(intervals[left]);
            left++;
         }


         boolean flag = true;

         // intervals[i][0] -> s1
         // intervals[i][1] -> e1
         // newInterval[0] -> s2
         // newInterval[1] -> e2

         // overlapping condition ->
         // e1 >= s2 && e2 >= s1
         
         while(left < intervals.length && flag==true){
            if(intervals[left][1] >= newInterval[0] && newInterval[1] >= intervals[left][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[left][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[left][1]);
            left++;
            } else {
                flag = false;
            }
            
         }
         
         list.add(newInterval);

         while(left < intervals.length) {
             list.add(intervals[left]);
             left++;
         }

        //  if(intervals.length == 0) list.add(newInterval);

         return list.toArray(new int[list.size()][]);
    }
}