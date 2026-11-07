class Solution {
    public String longestCommonPrefix(String[] strs) {
       Arrays.sort(strs);

       int i = 0;

       String str = "";

       while(i < strs[0].length() && strs[0].charAt(i) == strs[strs.length-1].charAt(i)) {
        str += strs[0].charAt(i);
        i++;
       }

       return str;
    }
}