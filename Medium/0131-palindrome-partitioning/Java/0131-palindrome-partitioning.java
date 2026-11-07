class Solution {
     public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    public List<List<String>> buildPalindromeList(String s) {

        int n = s.length();
        List<List<String>> palList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    list.add(s.substring(i, j + 1));
                }
            }
            palList.add(list);
        }
        return palList;
    }
   public void generate(int idx,
                         List<List<String>> palList,
                         List<String> path,
                         List<List<String>> result) {

        if (idx == palList.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (String str : palList.get(idx)) {

            path.add(str);
            generate(idx + str.length(), palList, path, result);
            path.remove(path.size() - 1);   // backtrack
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> palList = buildPalindromeList(s);
        List<List<String>> result = new ArrayList<>();

        generate(0, palList, new ArrayList<>(), result);
        return result;
    }
}