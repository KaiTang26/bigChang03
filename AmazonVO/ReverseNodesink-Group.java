
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        int count=0;
        ListNode pre = head;

        while(count<k && pre!=null){
            pre = pre.next;
            count++;
        }


        if(count==k){

            ListNode newHead = reverse(head, k);

            head.next = reverseKGroup(pre, k);

            return newHead;
        }

        return head;
        
    }


    public ListNode reverse(ListNode head, int k){

        ListNode pre = null;

        ListNode cur = head;

        while(k>0){

            ListNode temp = cur.next;
            cur.next =pre;
            pre = cur;
            head = temp;
            k--;
        }

        return pre;
    
    }
}
