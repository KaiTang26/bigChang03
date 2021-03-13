public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here

        if(A==null||A.length==0){
            return 0;
        }

        int ans = 1;

        int leftCountMax = 1;

        int leftStart = 1;

        while(leftStart<A.length){

            if(A[leftStart-1]>A[leftStart]){
                leftCountMax++;
                ans=Math.max(leftCountMax, ans);
            }else{
                leftCountMax=1;
            }

            leftStart++;
        }

        int rightStart = A.length-2;

        int rightCountMax = 1;

        while(rightStart>=0){

            if(A[rightStart+1]>A[rightStart]){
                rightCountMax++;
                ans=Math.max(rightCountMax, ans);
            }else{
                rightCountMax=1;
            }

            rightStart--;

        }

        return ans;

        
    }
}
