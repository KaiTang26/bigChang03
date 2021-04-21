import java.awt.List;

public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here

		Arrays.sort(nums);

		List<List<Integer>> ans = new ArrayList<>();

		backtrack(0, nums, new ArrayList<Integer>(), ans);

		return ans;
    }

	private void backtrack(int offset, int[] nums, List<Integer> subset, List<List<Integer>> ans){

		ans.add(new ArrayList<Integer>(subset));

		for(int i=offset; i<nums.length; i++){

			if(i!=offset && nums[i]==nums[i-1]){
				continue;
			}

			subset.add(nums[i]);

				backtrack(i+1, nums, subset, ans);

				subset.remove(subset.size()-1);

			
		}
	}
}