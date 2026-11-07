class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // List<int[]> list = new ArrayList<>();

        // for(int []el : intervals) list.add(el);

        // int a = 0;
        // int b = 0;
        // int c = 0;
        // int d = 0;

        // int i = 0;
        // while(i < list.size()){
        //      a = list.get(i)[0];
        //      b = list.get(i)[1];
        //      int j = 0;
             
        //     while(j < list.size()){
        //         if(i != j) {
        //              c = list.get(j)[0];
        //              d = list.get(j)[1];
        //              if(a <= c && b >= d) {
        //                list.remove(j);
        //                if(j < i) i--;
        //              } else j++;
        //         } else j++;
        //     }
        //     i++;
        // }
        // return list.size();


        Arrays.sort(intervals, (a, b) -> {
        if(a[0] == b[0])
        return Integer.compare(b[1], a[1]);
        return Integer.compare(a[0], b[0]);
        });

        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]);

       int i = 1;
       while(i < intervals.length) {
        int a = list.get(list.size()-1)[0];
        int b = list.get(list.size()-1)[1];
        int c = intervals[i][0];
        int d = intervals[i][1];

        if((b <= c) || (a < c && b < d)) {
            list.add(intervals[i]);
        }
        i++;
       }
        return list.size();
    } 
}