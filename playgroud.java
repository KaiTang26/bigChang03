import java.awt.List;

public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here

		List<List<Integer>> ans = new ArrayList<>();

		Arrays.sort(nums);

		DFS(nums, new boolean[nums.length], new ArrayList<Integer>(), ans);

		return ans;
    }


	private void DFS(int[] nums, boolean[] visit, List<Integer> permu, List<List<Integer>> ans){

		// nums should sorted
		if(permu.size()==nums.length){
			ans.add(new ArrayList<Integer>(permu));
			return;
		}

		for(int i=0; i<nums.length; i++){

			if(visit[i]){
				continue;
			}

			// avoid duplicated permutaions
			if(i>0 && nums[i]==nums[i-1]&& !visit[i-1]){
				continue;
			}

			permu.add(nums[i]);
			visit[i] = true;
			DFS(nums, visit, permu, ans);
			visit[i] =false;
			permu.remove(permu.size()-1);

		}
	}
}