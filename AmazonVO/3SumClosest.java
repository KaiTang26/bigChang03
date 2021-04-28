class Solution {
    public int threeSumClosest(int[] nums, int target) {        
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            int left = i+1;
            int right = nums.length-1;
            int searchValue = target -nums[i];

            while(left<right){

                int currentValue = nums[left]+nums[right];

                if(currentValue>searchValue){
                    right--;
                }else if(currentValue<searchValue){
                    left++;
                }else{
                    return target;
                }


                if(Math.abs(currentValue-searchValue)<Math.abs(diff)){
                    diff = currentValue-searchValue;
                }
            }

        }

        return target+diff;
        
    }
}