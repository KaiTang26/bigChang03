import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }else{
                map.put(n, 1);
            }
        }


        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            return b[1]-a[1];
        });

        for(int n : map.keySet()){

            int[] i = new int[2];
            i[0] = n;
            i[1] = map.get(n);
            queue.offer(i);
        }

        int[] ans = new int[k];

        while(!queue.isEmpty()&& k>=0){

            ans[k] = queue.poll()[0];
            k--;

        }

        return ans;
        
    }
}