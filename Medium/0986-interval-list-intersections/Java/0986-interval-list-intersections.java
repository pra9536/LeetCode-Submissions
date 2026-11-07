class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        // int[][] merge = Stream.concat(Arrays.stream(firstList), Arrays.stream(secondList)).toArray(int[][]::new);

        // Arrays.sort(merge, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length) {
           int s1 = firstList[i][0],
           e1 = firstList[i][1],
           s2 = secondList[j][0],
           e2 = secondList[j][1];

           if(s2 <= e1 && s1 <= e2) {
            list.add(new int[] {
                Math.max(s1, s2),
                Math.min(e1, e2)
            });
           }
           if(e1 < e2) i++;
           else j++;
        }
        return list.toArray(new int[list.size()][]);
    }
}