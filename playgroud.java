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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here

        ListNode cur = head;
        int len = 1;

        while(cur.next!=null){
            len++;
            cur = cur.next;
        }

        cur.next = head;

        ListNode newTail = head;

        for(int i=0; i<(len-k%len -1); i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;

    }

    
}