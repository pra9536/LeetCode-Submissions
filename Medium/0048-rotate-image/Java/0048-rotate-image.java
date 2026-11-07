class Solution {
    public void rotate(int[][] matrix) {
        
        // traverse

        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // reverse

        for(int i = 0; i<matrix.length; i++) {
            int start = 0;
            int end = matrix[0].length-1;
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        
    }
}