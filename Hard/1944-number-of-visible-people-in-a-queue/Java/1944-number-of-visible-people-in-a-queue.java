class Solution {
    public int[] canSeePersonsCount(int[] heights) {
       int ans[] = new int[heights.length];
       ans[heights.length-1] = 0;
       int k = heights.length-2;
       Stack<Integer> st = new Stack<>();
       st.push(heights[heights.length-1]);
       for(int i = heights.length-2; i>=0; i--){
        int count=0;
        while(!st.isEmpty() && st.peek() < heights[i]) {
            st.pop();
            count++;
        }
        if(st.isEmpty()) ans[k] = count;
        else if(st.peek() > heights[i]) ans[k] = count+1;
        st.push(heights[i]);
        k--;
       }
       return ans;
    }
}