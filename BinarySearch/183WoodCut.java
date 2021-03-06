public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L==null || L.length==0){
            return 0;
        }

        Arrays.sort(L);

        int start = 1;
        int end = L[L.length-1];

        while(start+1<end){

            int mid = start +(end-start)/2;

            if(countCuts(L, mid)>=k){
                start = mid;
            }else{
                end = mid;
            }

        }

        if(countCuts(L, end)>=k){
            return end;
        }

        if(countCuts(L, start)>=k){
            return start;
        }

        return 0;
    }

    public int countCuts(int[] L, int cLen){

        int count = 0;

        for(int l : L){
            count += l/cLen;
        }

        return count;

    }
}
