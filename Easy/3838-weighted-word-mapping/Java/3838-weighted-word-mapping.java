class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
      String ans = "";
        for(int i = 0; i<words.length; i++){
            String str = words[i];
            int sum = 0;
            for(int j = 0; j<str.length(); j++){
                sum += weights[str.charAt(j)-'a'];
            }

            sum = sum % 26;
            ans += (char)('z' - sum);
        }
        return ans;
    }
}