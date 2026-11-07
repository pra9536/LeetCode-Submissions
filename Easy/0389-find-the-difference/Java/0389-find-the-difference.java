class Solution {
    public char findTheDifference(String s, String t) {
       char ans = 0;
        for(int i = 0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            ans ^= ch1 ^ ch2;
         }
         ans ^= t.charAt(t.length()-1);
         return ans;
    }
}