import java.awt.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int target = 0;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        int len = nums.length;

        for(int i=0; i<len; i++){

            int searchValue = target-nums[i];

            List<List<Integer>> result = twoSum(nums, i+1, len-1, searchValue, nums[i]);

            if(result.size()>0){
                ans.addAll(result);
            }
        }

        return ans;
        
    }

    private List<Integer> twoSum(int[] nums, int start, int end, int target, int firstValue){

        List<List<Integer>> result = new ArrayList<>();

        int left = start;
        int right = end;

        while(left<right){

            int value = nums[left]+nums[right];

            if(value>target){
                right--;

            }else if(value<target){
                left++;

            }else{

                List<Integer> subList = new ArrayList<>();

                subList.add(firstValue);
                subList.add(nums[left]);
                subList.add(nums[right]);

                result.add(subList);
                left++;
                right--;

                while(left<right&& nums[left]==nums[left-1]){
                    left++;
                }


            }

        }

        return result;
    }
}
