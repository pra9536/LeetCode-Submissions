class Solution {
    public int repeatedStringMatch(String a, String b) {
        String newStr = "";
        int len1 = a.length();
        int len2 = b.length();

        int i = 0;
        int count = 0;

        while(i <= (len1+len2)/len1) {
            newStr += a;
            if(newStr.contains(b)) {
                return ++count;
            }
            count++;
            i++;
        }
        
        return -1;
    }
}