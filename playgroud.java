import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here

        int numberofEdges = edges.length;

        if(numberofEdges != (n-1)){
            return false;
        }


        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){


            map.put(i, new ArrayList<>());


        }

        for(int i=0; i<numberofEdges; i++){
            int[] edge =edges[i];

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);

        }






        Queue<Integer> queue = new LinkedList<>();

        Set<Integer> set = new HashSet<>();

        queue.offer(0);
        set.add(0);


        while(!queue.isEmpty()){
            int key = queue.poll();


            List<Integer> values = map.get(key);

            for(int i:values){


                if(!set.contains(i)){
                    queue.offer(i);
                    set.add(i);
                }

            }

        }

       

        return set.size()==n;
    }
}
