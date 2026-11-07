class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> temp = new HashSet<>();

        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') st.push(i);
            else if(ch == ')') {
                if(!st.isEmpty()) {
                    st.pop();
                } else {
                    temp.add(i);
                }
            }
        }
        while(!st.isEmpty()) temp.add(st.pop());

        String str = "";

        for(int i = 0; i<s.length(); i++) {
            if(!temp.contains(i)) str += s.charAt(i);
        }
        return str;
    }
}