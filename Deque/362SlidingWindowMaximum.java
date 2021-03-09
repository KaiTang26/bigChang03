import java.util.Deque;

public class Solution {
    /**
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here

        List<Integer> ans = new ArrayList<>();

        if(nums==null || nums.length==0){
            return ans;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<k-1; i++){
            int n = nums[i];

            while(!deque.isEmpty() && n>deque.peekLast()){
                deque.pollLast();
            }

            deque.offerLast(n);
        }


        for(int i=k-1; i<nums.length; i++){

            int n = nums[i];

            while(! deque.isEmpty() && n>deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(n);

            ans.add(deque.peekFirst());

            if(deque.peekFirst()==nums[i-k+1]){
                deque.pollFirst();
            }


        }

        return ans;

    }
}
