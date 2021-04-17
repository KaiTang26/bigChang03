import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Solution {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        
        PriorityQueue<Long> queue = new PriorityQueue<>();

        Set<Long> set = new HashSet<>();

        int[] seeds = new int[]{2,3,5};

        queue.add(Long.valueOf(1));
        set.add(Long.valueOf(1));

        for(int i=0; i<n; i++){

            Long value = queue.poll();
            if(i==(n-1)){
                return value.intValue();
            }

            for(int s : seeds){

                Long newValue = value*s;

                if(!set.contains(newValue)){
                    set.add(newValue);

                    queue.add(newValue);
                }
            }
        }

        return 0;
    }
}