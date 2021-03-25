import java.util.ArrayList;
import java.util.List;

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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here


        List<Integer> ans = new ArrayList();

        if(root==null){
            return ans;
        }

        List<Integer> left = inorderTraversal(root.left);

        ans.addAll(left);
        ans.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        ans.addAll(right);

        return ans;


    }
}