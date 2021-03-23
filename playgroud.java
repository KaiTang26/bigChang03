public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here

        int end = 10;

        while(reader.get(end)!=2147483647 &&reader.get(end)<=target){
            end *=2;
        }

        int start = 0;

        while(start+1<end){
            int mid = start+(end-start)/2;

            if(reader.get(mid)>target){
                end = mid;
            }else if(reader.get(mid)<target){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(reader.get(start)==target){
            return start;
        }else if(reader.get(end)==target){
            return end;

        }else{
            return -1;
        }
    }
}