class Solution {

    private void helper(List<List<Integer>> list, int s, int e, int freeStart, int freeEnd) {
        if(e < freeStart || s > freeEnd) {
            list.add(Arrays.asList(s, e));
            return;
        }

        if(s < freeStart) {
            list.add(Arrays.asList(s, freeStart-1));
        }

        if(e > freeEnd) {
            list.add(Arrays.asList(freeEnd + 1, e));
        }
    }
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {

        Arrays.sort(occupiedIntervals, (x, y) -> Integer.compare(x[0], y[0]));


        List<List<Integer>> result = new ArrayList<>();

        int s = occupiedIntervals[0][0];
        int e = occupiedIntervals[0][1];

        for(int i = 1; i<occupiedIntervals.length; i++) {
            int m = occupiedIntervals[i][0];
            int n = occupiedIntervals[i][1];

            if((long)m <= (long) e + 1) {
                e = Math.max(e, n);
            } else {
                helper(result, s, e, freeStart, freeEnd);
                s = m;
                e = n;
            }
        }


        helper(result, s, e, freeStart, freeEnd);

        return result;
        
    }
}