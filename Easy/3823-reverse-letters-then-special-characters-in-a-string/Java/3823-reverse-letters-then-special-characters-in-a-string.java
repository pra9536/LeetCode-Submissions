class Solution {
    public String reverseByType(String s) {
      ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        for(int i = s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
           if(Character.isLowerCase(ch)){
               list1.add(ch);
           } else {
               list2.add(ch);
           }
        }
        String newStr = "";
        int l1 = 0;
        int l2 = 0;
        for(int i = 0; i<s.length(); i++){
           char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                newStr += list1.get(l1++);
            } else{
                newStr += list2.get(l2++);
            }
        }
        return newStr;
    }
}