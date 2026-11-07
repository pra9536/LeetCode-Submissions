class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) return s;

        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i<numRows; i++) {
            list.add(new StringBuilder());
        }
        boolean flag = false;
        int idx = 0;

        for(int i = 0; i<s.length(); i++) {
            String ch = "" + s.charAt(i);

            if(idx == 0) {
                flag = true;
            } else if(idx == numRows - 1) {
                flag = false;
            }

            list.get(idx).append(ch);

            if(flag) idx++;
            else idx--;
        }

        String str = "";

        for(int i = 0; i<list.size(); i++) {
            str += list.get(i);
        }
        return str;
    }
}