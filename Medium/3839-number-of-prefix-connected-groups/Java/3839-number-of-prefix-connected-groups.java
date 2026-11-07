class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i<words.length; i++){
            String str = words[i];
            if(str.length() < k) continue;
            String temp = str.substring(0, k);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int ans = 0;
        for(int val : map.values()){
            if(val >= 2) ans++;
        }
        return ans;
    }
}