class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        // q.add(x);
        // size++;
       q.add(x);
       int size = q.size();
       while(size > 1){
        q.add(q.remove());
        size--;
       }
    }
    
    public int pop() {
        // if(size <= 0) return -1;
        // int temp = 1;
        // while(temp != size){
        //     q.add(q.remove());
        //     temp++;
        // }
        // size--;
        // return q.remove();

        return q.remove();
    }
    
    public int top() {
        // if(size <= 0) return -1;
        // int temp = 1;
        // while(temp != size){
        //     q.add(q.remove());
        //     temp++;
        // }
        // int top = q.peek();
        // q.add(q.remove());
        // return top;

        return q.peek();
        
    }
    
    public boolean empty() {
        return q.size() == 0;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */