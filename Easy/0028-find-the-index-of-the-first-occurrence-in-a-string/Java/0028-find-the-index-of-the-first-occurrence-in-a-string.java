class Solution {
    public int strStr(String haystack, String needle) {
         if(needle.length() > haystack.length()) return -1;

        // return haystack.indexOf(needle);

        int n = haystack.length();
        int m = needle.length();

        for(int i = 0; i<n; i++) {
            if(haystack.charAt(i) == needle.charAt(0) && (i + m) <= n) {
                String str = haystack.substring(i, i + m);
                if(str.equals(needle)) return i;
            }
        }
        return -1;
    }
}