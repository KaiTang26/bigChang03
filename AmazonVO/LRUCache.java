import java.util.Map;

class LRUCache {

    public int capacity;
    public Map<Integer, Node> map;
    public Node head = new Node(-1, -1);
    public Node tail =  new Node(-1,-1);

    public LRUCache(int capacity) {

        map = new HashMap<>();
        head.next=tail;
        tail.pre = head;
    }
    
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }

        Node curr = map.get(key);
        curr.pre.next = curr.next;
        curr.next.pre = curr.pre;

        curr.next = tail;
        curr.pre = tail.pre;
        tail.pre = curr;
        curr.pre.next = curr;

        return map.get(key).value;

        
    }
    
    public void put(int key, int value) {

        if(get(key)!=-1){
            map.get(key).value = value;
            return;
        }

        if(map.size()>=capacity){
            map.remove(head.next.key);
            head.next=head.next.next;
            head.next.pre = head;
        }

        Node node = new Node(key, value);
        map.put(key, node);

        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
        node.next = tail;
        return;
        
    }
}


class Node{
    public int key;
    public int value;
    public Node pre;
    public Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}