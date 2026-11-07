class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int C[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<n; i++){
            list.add(A[i]);
            set.add(B[i]);

            int count = 0;

            for(int num : list){
                if(set.contains(num)) count++;
            }

            C[i] = count;
        }
        return C;
    }
}