
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
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here


        ListNode pre = null;
        ListNode cur = head;

        while(m>1){
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode tail = cur;
        ListNode con = pre;



        for(int i=0; i<n; i++){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }


        if(con==null){
            head = pre;
        }else{
            con.next = pre;
        }
        
        tail.next = cur;


        return head;

        
    }
}