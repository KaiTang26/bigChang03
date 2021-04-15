import java.util.Queue;
import java.util.logging.Level;

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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        



    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data.equals("#")){
            return null;
        }

        String[] dataArray = data.substring(1,data.length()-1).split(",");

        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        TreeNode currentNode = null;

        boolean isLeftNode = true;


        for(int i=1; i<dataArray.length; i++){

            String value = dataArray[i];

            if(isLeftNode){

                currentNode = queue.poll();

                if(value.equals("#")){

                    currentNode.left = null;

                }else{

                    TreeNode newNode = new TreeNode(Integer.parseInt(value));

                    currentNode.left = newNode;

                    queue.offer(newNode);

                }

                isLeftNode = false;

            }else{

                if(value.equals("#")){
                    currentNode.right=null;
                }else{
                    TreeNode newNode = new TreeNode(Integer.parseInt(value));
                    currentNode.right = newNode;
                    queue.offer(newNode);
                }
                isLeftNode = true;

            }

        }

        return root;

    }
}