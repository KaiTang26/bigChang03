
class SVNRepo {
         public static boolean isBadVersion(int k);
    }

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here

        int start = 1;
        int end = n;

        while(start+1<end){
            int mid = start+(end-start)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(isBadVersion(start)){
            return start;
        }else{
            return end;
        }
    }
}
