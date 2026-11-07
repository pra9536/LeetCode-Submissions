class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
                                                                                                            
        char ans[][] = new char[n][m];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                ans[j][m-i-1] = boxGrid[i][j];
            }
        }

     for(int i = 0; i<m; i++){
        int k = n-1;
        for(int j = n-1; j>=0; j--){
            if(ans[j][i] == '*') k = j-1;

            else if(ans[j][i] == '#') { 
                ans[j][i] = '.';
                ans[k][i] = '#';
                k--;
            }
        }
     }

     return ans;

    }
}