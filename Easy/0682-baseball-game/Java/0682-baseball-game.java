class Solution {
    public int calPoints(String[] operations) {
        // ArrayList<Integer> list = new ArrayList<>();
        // int sum = 0;
        // list.add(Integer.parseInt(operations[0]));
        // for(int i = 1; i<operations.length; i++){
        //     if(operations[i].equals("C")){
        //         list.remove(list.size()-1);
        //     } else if(operations[i].equals("D")){
        //         int val = list.get(list.size()-1) * 2;
        //         list.add(val);
        //     } else if(operations[i].equals("+")){
        //         int sum2 = list.get(list.size()-1) + list.get(list.size()-2);
        //         list.add(sum2);
        //     } else{
        //         int val = Integer.parseInt(operations[i]);
        //         list.add(val);
        //     }
        // }
        // for(int num : list) sum += num;
        // return sum;

        Stack<Integer> st = new Stack<>();
        int sum = 0;
        for(int i = 0; i<operations.length; i++){
            if(st.isEmpty()){
                st.push(Integer.parseInt(operations[i]));
                sum += Integer.parseInt(operations[i]);
            } else if(operations[i].equals("C")){
                sum -= st.pop();
            } else if(operations[i].equals("D")){
                int val = st.peek();
                st.push(val*2);
                sum += val*2;

            } else if(operations[i].equals("+")){
                int val = st.pop();
                int sum1 = val + st.peek();
                st.push(val);
                st.push(sum1);
                sum += sum1;
            } else {
                st.push(Integer.parseInt(operations[i]));
                sum += Integer.parseInt(operations[i]);
            }
        }
        // int sum = 0;
        // while(!st.isEmpty()) sum += st.pop();
        return sum;
    }
}