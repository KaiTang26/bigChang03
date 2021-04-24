import jdk.internal.net.http.LineSubscriberAdapter;
import jdk.nashorn.internal.ir.LiteralNode;

public class ListNode {
      int val;
     ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }


 public class Solution {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapNodes(ListNode head, ListNode preNode1, ListNode preNode2) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node1 = preNode1.next;
        ListNode node2 = preNode2.next;

        preNode1.next = node2;
        preNode2.next = node1;

        ListNode temp = node2.next;
        node2.next = node1.next;
        node1.next = temp;

        return dummy.next;

    }
}