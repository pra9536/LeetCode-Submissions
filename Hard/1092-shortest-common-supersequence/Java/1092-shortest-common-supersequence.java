class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int [][]dp = new int[m+1][n+1];

        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder("");

        int i = m;
        int j = n;

        while(i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) i--;
            else  j--;
        }

        String lcs = sb.reverse().toString();

        i = 0;
        j = 0;
        int idx = 0;
        String ans = "";

        while(i < str1.length() && j < str2.length() && idx < lcs.length()) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            char ch = lcs.charAt(idx);
            if(ch1 != ch2 && ch1 != ch && ch2 != ch) {
                ans += ch1;
                ans += ch2;
                i++;
                j++;
            }
            else if(ch1 == ch && ch2 != ch){
                ans += ch2;
                j++;
            }
            else if(ch2 == ch && ch1 != ch) {
                ans += ch1;
                i++;
            }
            else {
                ans += ch;
                i++;
                j++;
                idx++;
            }
        }

        while(i < str1.length()) {
            ans += str1.charAt(i);
            i++;
        }

        while(j < str2.length()) {
            ans += str2.charAt(j);
            j++;
        }

        return ans;
    }
}