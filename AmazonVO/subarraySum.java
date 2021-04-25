import java.util.Map;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here

        Map<Integer, Integer> prefixMap = new HashMap<>();

        List<Integer> ans = new ArrayList<>();

        int prefix = 0;

        prefixMap.put(prefix, 0);

        for(int i=1; i<=nums.length; i++){

            prefix = prefix +nums[i-1];

            if(prefixMap.containsKey(prefix)){
                ans.add(prefixMap.get(prefix));
                ans.add(i-1);

                return ans;

            }else{

                prefixMap.put(prefix, i);
            }


        }

        return ans;


    }
}