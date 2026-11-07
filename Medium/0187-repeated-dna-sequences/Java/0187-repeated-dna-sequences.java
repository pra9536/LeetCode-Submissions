class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> list = new ArrayList<>();

        if (s.length() < 10) {
            return list;
        }

        Map<Character, Integer> map = new HashMap<>();

        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        int sum = 0;

        // Encode first 10 characters
        for (int i = 0; i < 10; i++) {
            int val = map.get(s.charAt(i));
            sum += val * (int) Math.pow(4, 9 - i);
        }

        seen.add(sum);

        int left = 0;
        int power = (int) Math.pow(4, 9);

        for (int right = 10; right < s.length(); right++) {

            int newVal = map.get(s.charAt(right));
            int oldVal = map.get(s.charAt(left));

            left++;

            // Rolling hash
            sum = (sum - oldVal * power) * 4 + newVal;

            if (seen.contains(sum)) {
                repeated.add(s.substring(left, right + 1));
            } else {
                seen.add(sum);
            }
        }

        list.addAll(repeated);

        return list;
    }
}