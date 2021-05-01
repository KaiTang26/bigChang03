import java.lang.reflect.Array;
import java.util.Queue;

class Solution {
    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, (a,b)->{
            return a[1]-b[1];
        });

        Queue<int[]> queue = new LinkedList<>();


        for(int i=0; i<intervals.length;i++){

            int[] item = intervals[i];

            if(queue.isEmpty()||queue.getLast()[1]<item[0]){

                queue.add(item);
            }else{
                queue.getLast()[1] = Math.max(queue.getLast()[1], item[1]);
            }

        }


        int[][] ans = new int[queue.size()][2];

        for(int i=0; i<ans.length; i++){

            ans[i] = queue.poll();
        }

        return ans;



        
    }
}