class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        list.add(new int[]{intervals[0][0], intervals[0][1]});

        for(int i = 1; i<intervals.length; i++) {
            int[] temp = list.remove(list.size()-1);
            int s1 = temp[0];
            int e1 = temp[1];

            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if(s2 <= e1) {
                s1 = Math.min(s1, s2);
                e1 = Math.max(e1, e2);
            } else {
                list.add(new int[]{s1, e1});
                s1 = s2;
                e1 = e2;
            }
            list.add(new int[]{s1, e1});
        }

       

        return list.stream().toArray(int[][]::new);
    }
}