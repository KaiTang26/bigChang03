import java.awt.List;
import java.util.Queue;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> subAns = new ArrayList<>();

            for(int i=0; i<size; i++){

                TreeNode node = queue.poll();
                subAns.add(node.val);

                if(node.left!=null){
                    queue.offer(node.left);
                }

                if(node.right !=null){
                    queue.offer(node.right);
                }

            }

            if(subAns.size()>0){
                ans.add(subAns);
            }

        }

        return ans; 
    }
}
