class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            q.add(i);
        }

        int i = 1;
        while(q.size() != 1){
            if(i==k){
                q.remove();
                i = 1;
            }
            else{
                q.add(q.remove());
                i++;
            }

        }

        return q.peek();
    }
}