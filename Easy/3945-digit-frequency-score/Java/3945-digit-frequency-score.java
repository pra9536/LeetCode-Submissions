class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        while(n>0){
            int digit = n%10;

            map.put(digit, map.getOrDefault(digit, 0) + 1);

            n = n / 10;
        }

        int ans = 0;

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            ans += e.getKey() * e.getValue();
        }

        return ans;
    }
}