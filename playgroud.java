import java.util.HashSet;
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
        
        public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                              Map<UndirectedGraphNode, Integer> values,
                                              UndirectedGraphNode node,
                                              int target) {
            // write your code here


            Queue<UndirectedGraphNode> queue = new LinkedList<>();
            Set<UndirectedGraphNode> set = new HashSet<>();

            queue.offer(node);

            while(!queue.isEmpty()){
                UndirectedGraphNode cnode = queue.poll();
                set.add(cnode);

                int value = values.get(cnode);

                if(value == target){

                    return cnode;
                }


                for(UndirectedGraphNode n : cnode.neighbors){

                    if(!set.contains(n)){
                        queue.offer(n);
                    }

                }


            }


            return null;
        }
    }