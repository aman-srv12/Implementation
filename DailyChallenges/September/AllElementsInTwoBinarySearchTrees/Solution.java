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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        if(root1 == null && root2 == null){
            return new ArrayList<>();
        }
        
        if(root1 == null){
            List<Integer> a = new ArrayList<>();
            getListFromTree(root2, a);
            return a;
        }
        
        if(root2 == null){
            List<Integer> b = new ArrayList<>();
            getListFromTree(root1, b);
            return b;
        }
        
        List<Integer> out = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        getListFromTree(root1, a);
        List<Integer> b = new ArrayList<>();
        getListFromTree(root2, b);
        
        int i = 0, j = 0;
        while(i < a.size() && j < b.size()){
            if(a.get(i) <= b.get(j)){
                out.add(a.get(i));
                i++;
            }
            else if(a.get(i) > b.get(j)){
                out.add(b.get(j));
                j++;
            }
        }
        while(i < a.size()){
            out.add(a.get(i));
            i++;
        }
        while(j < b.size()){
            out.add(b.get(j));
            j++;
        }
        return out;
    }
    
    public void getListFromTree(TreeNode root, List<Integer> list){
        
        if(root == null)
            return;
        
        getListFromTree(root.left, list);
        list.add(root.val);
        getListFromTree(root.right, list);
    }
}
