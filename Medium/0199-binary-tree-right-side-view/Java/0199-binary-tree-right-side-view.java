/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void getAns(TreeNode root, List<Integer> list, int currLevel){
       if(root == null) return;
       if(currLevel < list.size()) list.set(currLevel, root.val);
       else list.add(root.val);
       getAns(root.left, list, currLevel+1);
       getAns(root.right, list, currLevel+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getAns(root, list, 0);
        return list;
    }
}