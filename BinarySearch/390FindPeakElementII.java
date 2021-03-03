public class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here

        List<Integer> ans = new ArrayList<Integer>();

        int start = 0;
        int end = A.length-1;

        while(start+1<end){

            int mid = start + (end-start)/2;

            int col = findMax(A[mid]);

            if(A[mid][col]>A[mid-1][col] && A[mid][col]>A[mid+1][col]){

                ans.add(mid);
                ans.add(col);
                break;
            }else if(A[mid][col]<A[mid-1][col] && A[mid][col]>A[mid+1][col]){
                end = mid;

            }else if(A[mid][col]>A[mid-1][col] && A[mid][col]<A[mid+1][col]){
                start = mid;
            }else if(A[mid][col]<A[mid-1][col] && A[mid][col]<A[mid+1][col] && A[mid+1][col]>A[mid-1][col]){
                start = mid;
            }else{
                end = mid;
            }

        }

        return ans;
    }

    public int findMax(int[] B){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0; i<B.length; i++){
            if(B[i]>max){
                max = B[i];
                index = i;
            }
        }
        return index;
    }
}