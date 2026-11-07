class Solution {
    public static int getMaxArea(int heights[]) {
        // code here
       int nextSmaller[] = new int[heights.length];
       Stack<Integer> st = new Stack<>();
       int k = heights.length-1;
       for(int i = heights.length-1; i>=0; i--){
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
        if(st.isEmpty()) nextSmaller[k] = heights.length;
        else nextSmaller[k] = st.peek();
        st.push(i);
        k--;
       }

       int prevSmaller[] = new int[heights.length];
       st = new Stack<>();
       k = 0;
       for(int i = 0; i<heights.length; i++){
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
        if(st.isEmpty()) prevSmaller[k] = -1;
        else prevSmaller[k] = st.peek();
        st.push(i);
        k++;
       }
         
       int max = Integer.MIN_VALUE;
       for(int i = 0; i<heights.length; i++){
           max = Math.max(max, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
       }
       return max;

    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int [][]mat = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                mat[i][j] = (int)(matrix[i][j]-'0');
            }
        }

        for(int i = 1; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1) mat[i][j] += mat[i-1][j];
            }
        }

        int max = 0;
        for(int []row : mat){
            max = Math.max(max, getMaxArea(row));
        }
        return max;
    }
}