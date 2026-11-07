class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int left = 0;
        // int right = 0;

        // HashMap<Character, Integer> map = new HashMap<>();

        // int max = 0;

        // for(right = 0; right<s.length(); right++) {
        //     if(map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {
        //         left = map.get(s.charAt(right)) + 1;
        //     }
        //     map.put(s.charAt(right), right);

        //     max = Math.max(max, right - left + 1);
        // }

        // return max;


        Set<Character> set = new HashSet<>();

        int left = 0;

        int max = 0;

        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}