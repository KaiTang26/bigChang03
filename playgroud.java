/**
 * Definition of TreeNode:
  */
  public class TreeNode {
     public int val;
      public TreeNode left, right;
     public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here

        return DFS(root, 0);


    }

    public int DFS(TreeNode node, int depth){

        if(node==null){
            return depth;
        }


        return Math.max(DFS(node.left, depth+1), DFS(node.right, depth+1));

    }
}