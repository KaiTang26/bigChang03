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
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here

        if(str==null || str.length==0){
            return;
        }

        offset = offset%str.length;


        reverse(str, 0, str.length-offset-1);
        reverse(str, str.length-offset, str.length-1);
        reverse(str, 0, str.length-1);
    }

    private void reverse(char[] str, int start, int end){

        int left = start;
        int right = end;

        while(left<right){
            
            char temp = str[right];
            str[right] = str[left];
            str[left] = temp;
            left++;
            right--;
        }
    }
}