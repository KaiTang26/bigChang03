import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;

class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 };
 

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {


        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
    
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();

        for(DirectedGraphNode n : graph){

            if(!indegree.containsKey(n)){
                indegree.put(n, 0);
            }

           for(DirectedGraphNode i: n.neighbors){

                if(indegree.containsKey(i)){
                    indegree.put(i, indegree.get(i)+1);
                }else{
                    indegree.put(i, 1);
                }

           }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();




        for(DirectedGraphNode n : graph){

            int value = indegree.get(n);

            if(value==0){
                queue.offer(n);
            }
        }

        while(!queue.isEmpty()){

            DirectedGraphNode n = queue.poll();
            ans.add(n);

            for(DirectedGraphNode i : n.neighbors){

                indegree.put(i, indegree.get(i)-1);

                if(indegree.get(i)==0){
                    queue.offer(i);
                }
            }
        }


        return ans;


    }
}