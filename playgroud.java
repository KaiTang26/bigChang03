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
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here

        ListNode midHead = findMiddNext(head);

        ListNode reversedMidHead = reverseList(midHead);

        ListNode dummy = new ListNode(-1);
        
        ListNode cur = dummy;

        boolean isleft = true;

        while(head!=null && reversedMidHead !=null){

            if(isleft){
                cur.next = head;
                head = head.next;
            }else{
                cur.next = reversedMidHead;
                reversedMidHead = reversedMidHead.next;
            }

            isleft = !isleft;
            cur = cur.next;
        }

        if(head !=null){
            cur.next =head;
        }

        if(reversedMidHead !=null){
            cur.next = reversedMidHead;
        }

        head = dummy.next;
    }

    public ListNode findMiddNext(ListNode head){

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midHead = slow.next;
        slow.next = null;
        return midHead;
    }

    public ListNode reverseList(ListNode head){

        ListNode pre = null;

        ListNode cur = head;

        while(cur!=null){

            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur =temp;

        }

        return pre;

    }
}