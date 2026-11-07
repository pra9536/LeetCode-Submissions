class Solution {
    public boolean isPalindrome(String s) {
       String str = s.toLowerCase();

      int i = 0;
      int j = s.length()-1;

      while(i < j) {
        char first = str.charAt(i);
        char last = str.charAt(j);

        if(first == last) {
            i++;
            j--;
        } else if(!Character.isLetterOrDigit(first)) i++;
        else if(!Character.isLetterOrDigit(last)) j--;
        else return false;
      }
      return true;
    }
}