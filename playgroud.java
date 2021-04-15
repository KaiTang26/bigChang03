import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class ListNode {
         int val;
        ListNode next;
         ListNode(int x) { val = x; }
     }

     public class Solution {
        /**
         * @param root the root of binary tree
         * @return a lists of linked list
         */
        public List<ListNode> binaryTreeToLists(TreeNode root) {
            // Write your code here

            List<ListNode> ans = new ArrayList<>();

            if(root==null){
                return ans;
            }

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();

                ListNode dummy = new ListNode(-1);
                ListNode current = dummy;

                for(int i=0; i<size; i++){

                    TreeNode node = queue.poll();

                    current.next = new ListNode(node.val);

                    if(node.left !=null){
                        queue.offer(node.left);
                    }

                    if(node.right != null){
                        queue.offer(node.right);
                    }

                    current = current.next;

                }

                ans.add(dummy.next);
            }


            return ans;
        }
    }