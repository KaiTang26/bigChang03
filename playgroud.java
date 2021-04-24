import jdk.internal.net.http.LineSubscriberAdapter;
import jdk.nashorn.internal.ir.LiteralNode;

public class ListNode {
      int val;
     ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }


 
 public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here

        int lenA = A.length;
        int lenB = B.length;
        int[] ans = new int[lenA+lenB];
        int index = 0;
        int iA = 0;
        int iB = 0;

        while(iA<lenA && iB<lenB){
            if(A[iA]>B[iB]){
                ans[index] = B[iB];
                iB++;
            }else{
                ans[index] = A[iA];
                iA++;
            }
            index++;
        }

        while(iA<lenA){
            ans[index] = A[iA];
            iA++;
            index++;
        }

        while(iB<lenB){
            ans[index] = B[iB];
            iB++;
            index++;
        }

        return ans;
    }
}