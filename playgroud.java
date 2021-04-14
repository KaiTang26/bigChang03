import java.util.Queue;
import java.util.logging.Level;

import jdk.nashorn.api.tree.Tree;

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
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here

        


        List<List<Integer>> ans = new ArrayList<>();

        if(root==null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int breadth = queue.size();

            List<Integer> level = new ArrayList<>();

            for(int i=0; i<breadth; i++){
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left!=null){
                    queue.offer(node.left);
                }

                if(node.right!=null){
                    queue.offer(node.right);
                }

            }

            ans.add(level);

           
        }

        return ans;


    }
}