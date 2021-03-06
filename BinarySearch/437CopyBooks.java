public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {


        if(pages==null || pages.length==0){
            return 0;
        }
        // write your code here

        int maxTime = 0;
        
        for(int i :pages){
            maxTime +=i;
        }

        int start = 0;
        int end = maxTime;

        while(start+1<end){

            int mid = start+(end-start)/2;

            if(check(pages, maxTime, mid, k)){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(check(pages, maxTime, start, k)){
            return start;
        }else{
            return end;
        }
    }

    public boolean check(int[] pages, int maxTime, int curr, int k){

        if(curr*k<maxTime){
            return false;
        }


        int people = k;
        int remain = 0;


        for(int p : pages){

            if(p>curr){
                return false;
            }

            if(remain<p){
                people--;
                remain = curr;
            }

            remain-=p;

        }


        return people>=0;

    }
}