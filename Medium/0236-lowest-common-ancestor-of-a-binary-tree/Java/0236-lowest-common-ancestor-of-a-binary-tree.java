/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean rootToLeaf(TreeNode root, TreeNode n, ArrayList<TreeNode> list){
        if(root == null) return false;
        list.add(root);
         if(root == n) return true;
        if(rootToLeaf(root.left, n, list) || rootToLeaf(root.right, n, list)) return true;
        list.remove(list.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root == null) return null;
        // if(root.val == p.val || root.val == q.val) return root;
        // TreeNode left = lowestCommonAncestor(root.left, p, q);
        // TreeNode right = lowestCommonAncestor(root.right, p, q);
        // if(left != null && right != null) return root;
        // if(left == null) return right;
        // return left;


        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();
        rootToLeaf(root, p, list1);
        rootToLeaf(root, q, list2);
        int i = 0;
        while(i < list1.size() && i < list2.size()){
            if(list1.get(i) != list2.get(i)) break;
            i++;
        }
        return list1.get(i-1);
    }
}