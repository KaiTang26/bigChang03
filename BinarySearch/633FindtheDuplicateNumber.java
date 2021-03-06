public class Solution {
    /**
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length-1;

        while(start+1<end){

            int mid = start + (end-start)/2;

            if(count(nums, mid)<=mid){
                start = mid;
            }else{
                end = mid;
            }

        }


        if(count(nums, end)>end){
            return end;
        }else{
            return start;
        }
    }

    public int count(int[] nums, int index){

        int count = 0;

        for(int i : nums){

            if(i<=index){
                count++;
            }
        }

        return count;
    }
}
