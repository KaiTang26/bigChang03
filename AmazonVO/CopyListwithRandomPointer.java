
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {

        if(head==null){
            return null;
        }
        
        Node pointer = head;

        while(pointer!=null){

            Node copyNode = new Node(pointer.val);
            copyNode.next = pointer.next;
            pointer.next = copyNode;
            pointer = copyNode.next;
        }

        Node pointerTwo = head;

        while(pointerTwo!=null){
            pointerTwo.next.random = pointerTwo.random.next;
            pointerTwo = pointerTwo.next.next;
        }

        Node dummy = new Node(-1);
        Node cpHead = dummy;

        while(head!=null){
            cpHead.next = head.next;
            head.next = head.next.next;
            head = head.next;
            cpHead = cpHead.next;
        }

        return dummy.next;
    }
}
