class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int value = target - nums[i];
            if(map.containsKey(value)){
                ans[0] = map.get(value);
                ans[1] = i;
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}



class Solution {
    public int[] twoSum(int[] nums, int target) {

       Pair[] pairArray = new Pair[nums.length];

        int[] ans = new int[2];

        for(int i=0; i<nums.length; i++){
            pairArray[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pairArray, (a, b)->{
            return a.val - b.val;
        });

        int left = 0;
        int right = nums.length-1;

        while(left<right){

            int value = pairArray[left].val+pairArray[right].val;

            if(value>target){
                right--;

            }else if(value<target){
                left++;

            }else{

                int leftIndex = pairArray[left].index;
                int rightIndex = pairArray[right].index;

                ans[0] = leftIndex>rightIndex?rightIndex:leftIndex;
                ans[1] = leftIndex>rightIndex?leftIndex:rightIndex;
                break;
            }
        }

        return ans;
        
    }
}

class Pair{
    public int val;
    public int index;

    public Pair(int val, int index){

        this.val = val;
        this.index = index;
    }
}
