class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();

        for(int n : arr1){
            String str = String.valueOf(n);

            String prefix = "";

            for(int i = 0; i<str.length(); i++){
                prefix += str.charAt(i);

                set.add(prefix);
            }
        }

        int max = 0;

        for(int n : arr2){
            String str = String.valueOf(n);

            String prefix = "";

            for(int i = 0; i<str.length(); i++){
                prefix += str.charAt(i);

                if(set.contains(prefix)) {
                    max = Math.max(max, prefix.length());
                }
            }
        }
        return max;
    }
}