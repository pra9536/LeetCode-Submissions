class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i<strs.length; i++) {
            String str = strs[i];

            char ch[] = str.toCharArray();

            Arrays.sort(ch);

            String newStr = new String(ch);

            if(map.containsKey(newStr)) {
                     map.get(newStr).add(str);
            } else {
                map.put(newStr, new ArrayList<>());
                map.get(newStr).add(str);
            }
        }

        List<List<String>> list = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            list.add(new ArrayList<>(entry.getValue()));
        }

        return list;
    }
}