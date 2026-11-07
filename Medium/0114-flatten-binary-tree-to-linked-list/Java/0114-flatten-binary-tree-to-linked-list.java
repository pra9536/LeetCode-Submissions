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
    public void preOrder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
    public void flatten(TreeNode root) {
    //     if(root == null) return;
    //     TreeNode temp = root.right;
    //    flatten(root.left);
    //    flatten(root.right);
    //     root.right = root.left;
    //     root.left = null;
    //     TreeNode curr = root;
    //     while(curr.right != null){
    //         curr = curr.right;
    //     }
    //     curr.right = temp;

    ArrayList<TreeNode> list = new ArrayList<>();
    preOrder(root, list);
    TreeNode curr = root;
    int i = 1;
    while(i < list.size()){
        curr.left = null;
        curr.right = list.get(i);
        i++;
        curr = curr.right;
    }
    }
}