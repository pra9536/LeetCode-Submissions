class Solution {
    public int findGCD(int[] nums) {
        int smallest = nums[0];
        int largest = nums[0];
        for(int n : nums){
            smallest = Math.min(smallest, n);
            largest = Math.max(largest, n);
        }

        // int diff = largest - smallest;
        // int ans = 0;
        // if(diff == 0) return largest;
        // for(int i = 1; i*i<=diff; i++){
        //     int temp = diff / i;
        //     if(diff % i == 0 && smallest % i == 0 && largest % i == 0){
        //         ans = Math.max(ans, i);
        //     } 
        //     if(diff % temp == 0 && smallest % temp == 0 && largest % temp == 0){
        //         ans = Math.max(ans, temp);
        //     }
        // }
        // return ans;

        while(smallest != 0){
            int temp = smallest;
            smallest = largest % smallest;
            largest = temp;
        }
        return largest;
    }
}