import java.util.PriorityQueue;

public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        if(lists==null || lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });

        for(ListNode l : lists){
            if(l!=null){
                pq.offer(l);
            }
        }

        while(!pq.isEmpty()){

            ListNode node = pq.poll();
            head.next = node;
            head = head.next;

            if(node.next!=null){
                pq.offer(node.next);
            }

        }

        return dummy.next;
    }
}