import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here

        int[] ans = new int[nums.length];

        ArrayList<Integer> temp = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            temp.add(nums[i]);
            Collections.sort(temp);
            int median = (temp.size()-1)/2;

            ans[i] = temp.get(median);

        }

        return ans;
    }


   
}




public class Solution2 {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here

        int[] ans = new int[nums.length];

        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        };

        // poll small value
        Queue<Integer> big = new PriorityQueue<Integer>();

        // poll large value
        Queue<Integer> small = new PriorityQueue<Integer>(customComparator);

        small.offer(nums[0]);
        ans[0]=nums[0];


        for(int i=1; i<nums.length; i++){

            int sr = small.peek();
            if(nums[i]>sr){
                big.offer(nums[i]);
            }else{
                small.offer(nums[i]);
            }


            int bs = big.size();
            int ss = small.size();

            if(ss<bs){
                small.offer(big.poll());
            }else if(ss>bs+1){
                big.offer(small.poll());
            }

            ans[i] = small.peek();

        }


        return ans;

       
    }


   
}