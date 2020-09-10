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
    public int sumRootToLeaf(TreeNode root) {
        
        if(root == null)
            return 0;
        List<String> l = new ArrayList<>();
        helper(root, l, "");
        int s = 0;
        for(String x : l){
            int num = getInteger(x);
            s += num;
        }
        return s;
    }
    
    public void helper(TreeNode root, List<String> l, String s){
        
        if(root == null){
            return;
        }
        s += root.val;
        if(root.left == null && root.right == null){
            l.add(s);
            return;
        }
        helper(root.left, l, s);
        helper(root.right, l, s);
    }
    
    public int getInteger(String x){
        
        if(x == null || x.length() == 0)
            return 0;
        
        int k = 0;
        int out = 0;
        for(int i = x.length() - 1; i >= 0; i--){
            char ch = x.charAt(i);
            int ele = ch == '1' ? 1 : 0;
            out += (ele * Math.pow(2, k));
            k++;
        }
        return out;
    }
}
