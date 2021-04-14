import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[] optimizingBoxWeight(int[] nums) {
        int target = 0;
        Integer[] numArray = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            int v = nums[i];
            numArray[i]=v;
            target +=v;
        }
        target = target/2;
        Arrays.sort(numArray, Collections.reverseOrder());
        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i : numArray){
            sum +=i;
            ans.add(i);
            if(sum>target){
                break;
            }
        }
        Collections.sort(ans);
        int[] ansArray = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }
}

public class Solution2 {
    public int[] optimizingBoxWeight(int[] nums) {

        int target = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i : nums){
            target +=i;
            queue.add(i);
        }
        target = target/2;

        List<Integer> ansList = new ArrayList<>();

        int sum = 0;

        while(!queue.isEmpty()&&sum<target){
            int v = queue.poll();
            sum +=v;
            ansList.add(v);
        }

        Collections.sort(ansList);

        int[] ans = new int[ansList.size()];

        for(int i=0; i<ansList.size(); i++){
            ans[i] = ansList.get(i);
        }

        return ans;

        
        
    }
}
