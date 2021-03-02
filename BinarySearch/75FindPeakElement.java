import jdk.nashorn.internal.ir.CallNode.EvalArgs;

public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here

        if(A==null || A.length==0){
            return 0;
        }

        int start = 0;
        int end = A.length-1;

        while(start+1<end){
            int mid = start+(end-start)/2;
            
        }

        if(A[start]>A[end]){
            return start;
        }else{
            return end;
        }
    }
    
}