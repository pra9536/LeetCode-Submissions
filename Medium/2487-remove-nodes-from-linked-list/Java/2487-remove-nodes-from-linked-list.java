/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        // Stack<Integer> st = new Stack<>();
        // ListNode temp = head;
        // while(temp != null){
        //     int val = temp.val;
        //     if(st.isEmpty()) st.push(val);
        //     else if(val > st.peek()){
        //         while(!st.isEmpty() && val > st.peek()){
        //             st.pop();
        //         }
        //         st.push(val);
        //     } else {
        //         st.push(val);
        //     }
        //     temp = temp.next;
        // }
        // Stack<Integer> st2 = new Stack<>();
        // while(!st.isEmpty()){
        //     st2.push(st.pop());
        // }
        // ListNode curr = new ListNode(st2.pop());
        // head = curr;
        // while(!st2.isEmpty()){
        //     temp = new ListNode(st2.pop());
        //     curr.next = temp;
        //     curr = temp;
        // }
        // return head;

        Stack<ListNode> st = new Stack<>();

        ListNode temp = head;

        while(temp != null){
            while(!st.isEmpty() && st.peek().val < temp.val){
                st.pop();
            }
            st.push(temp);
            temp = temp.next;
        }

        while(!st.isEmpty()){
            ListNode top = st.pop();
            top.next = temp;
            temp = top;
        }

        return temp;
    }
}