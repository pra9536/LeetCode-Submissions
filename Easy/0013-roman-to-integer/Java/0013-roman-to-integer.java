class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        HashMap<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        
        for(int i = 0; i<s.length(); i++){
            String str = "";
            if((i+1) < s.length() && map.get(String.valueOf(s.charAt(i))) < map.get(String.valueOf(s.charAt(i+1)))) {
                str = "" + s.charAt(i) + s.charAt(i+1);
                i++;
            } else {
                str = "" + s.charAt(i);
            }

            int val = map.get(str);
            ans += val;
        }

        return ans;
    }
}