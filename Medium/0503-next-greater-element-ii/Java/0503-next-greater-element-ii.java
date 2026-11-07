class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int temp[] = new int[nums.length * 2];
        for(int i = 0; i<temp.length; i++){
            temp[i] = nums[i%nums.length];
        }
        List<Integer> list = new ArrayList<>();
        Stack<Integer> st= new Stack<>();

        for(int i = temp.length-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= temp[i]){
                st.pop();
            }
            if(st.isEmpty()) list.add(-1);
            else list.add(st.peek());
            st.push(temp[i]);
        }

        Collections.reverse(list);
        int arr[] = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
             arr[i] = list.get(i);
        }
        return arr;

        // Stack<Integer> st = new Stack<>();
        // for(int i = nums.length-1; i>=0; i--){
        //     st.push(nums[i]);
        // }

        // List<Integer> list = new ArrayList<>();
        // for(int i = nums.length-1; i>=0; i--){
        //     while(!st.isEmpty() && st.peek() <= nums[i]) st.pop();
        //     if(st.isEmpty()) list.add(-1);
        //     else list.add(st.peek());
        //     st.push(nums[i]);
        // }
        // Collections.reverse(list);
        // int ans[] = new int[list.size()];
        // int k = 0;
        // for(int n : list){
        //     ans[k] = n;
        //     k++;
        // }
        // return ans;

    }
}