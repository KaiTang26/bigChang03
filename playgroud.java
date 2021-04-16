public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
    }

    public void quickSort(int start, int end, int[] A){

        int left = start;
        int right = end;

        int p = A[start];

        while(left<=right){

            while(left<=right && A[left]<p){
                left++;
            }

            while(left<=right && A[right]>p){
                right--;
            }

            if(left<=right){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(start, right, A);

        quickSort(left, end, A);

        
    }
}
