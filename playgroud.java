import java.awt.List;
import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here

		List<List<Integer>> ans = new ArrayList<>();

		if(nums==null){
			return ans;
		}

		backtracking(0, nums, new ArrayList<>(), ans);

		return ans;

    }

	private void backtracking(int offset, int[] nums, List<Integer> subset, List<ArraryList<Integer>> ans){

		ans.add(new ArraryList<Integer>(subset));

		for(int i=offset; i<nums.length; i++){

			subset.add(nums[i]);
			backtracking(i+1, nums, subset, ans);
			subset.remove(subset.size()-1);
		}
	}
}