class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
       
        int i = 0;
        while(i < n){
            char ch = chars[i];
            int count = 0;
            while(i < n && chars[i] == ch){
                count++;
                i++;
            }
            chars[idx] = ch;
            idx++;
            if(count > 1){
                String str = String.valueOf(count);
                for(int j = 0; j<str.length(); j++){
                    chars[idx] = str.charAt(j);
                    idx++;
                }
            } 
        }
        return idx;
    }
}