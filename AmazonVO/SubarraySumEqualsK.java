import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        int count = 0;
        int sum = 0;

        for(int i=1; i<=nums.length; i++){
            sum += nums[i-1];

            if(prefix.containsKey(sum-k)){
                count += prefix.get(sum-k);
            }

            if(prefix.containsKey(sum)){
                prefix.put(sum, prefix.get(sum)+1);
            }else{
                
                prefix.put(sum, 1);
            }
        }

        return count;
        
    }
}