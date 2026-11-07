class Solution {
    public long getNCR(int n, int r){
        long rs = 1;
        for(int i = 0; i<r; i++){
            rs *= (n - i);
            rs /= (i + 1);
        }
        return rs;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        // temp.add(1);
        // for(int i = 1; i<=rowIndex; i++){
        //     List<Integer> curr = temp;
        //     temp = new ArrayList<>();
        //     int sum = 0;
        //     temp.add(1);
        //     for(int j = 0; j<curr.size()-1; j++){
        //         sum = curr.get(j)+curr.get(j+1);
        //         temp.add(sum);
        //     }
        //     temp.add(1);
        // }

        for(int i = 0; i<=rowIndex; i++){
            temp.add((int)getNCR(rowIndex, i));
        }

        return temp;
    }
}