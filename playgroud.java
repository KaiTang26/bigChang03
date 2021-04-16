
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
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here

        ListNode dumy = new ListNode(-1);
        ListNode pointer = dumy;

       

        while(l1!=null && l2!=null){

            if(l1.val>l2.val){

                pointer.next = l2;
                l2 = l2.next;

            }else{

                pointer.next =l1;
                l1 = l1.next;

            }
             pointer = pointer.next;

        }

        if(l1!=null){
            pointer.next = l1;
        }

        if(l2!=null){
            pointer.next = l2;
        }

        return dumy.next;


    }
}