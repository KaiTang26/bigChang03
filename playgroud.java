import java.util.Map;
import java.util.Queue;

class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) {
            label = x;
             neighbors = new ArrayList<UndirectedGraphNode>();
        }
     }
    
   
   public class Solution {
       /**
        * @param node: A undirected graph node
        * @return: A undirected graph node
        */
       public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
           // write your code here

           Queue<UndirectedGraphNode> queue = new LinkedList<>();

           Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

          // UndirectedGraphNode root = new UndirectedGraphNode(node.label);

           
           queue.offer(node);

           while(!queue.isEmpty()){

            UndirectedGraphNode currentNode = queue.poll();

            map.put(currentNode, new UndirectedGraphNode(currentNode.label));

            for( UndirectedGraphNode n : currentNode.neighbors){
                if(!map.containsKey(n)){
                    queue.offer(n);
                }
            }

           }


          


       }
   }