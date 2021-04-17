import java.util.PriorityQueue;

public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here

        if(arrays==null || arrays.length==0){

            return null;
        }

        int limit = 0;


        PriorityQueue<Record> queue = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });

        for(int i=0; i<arrays.length; i++){
            limit += arrays[i].length;
            if(arrays[i].length>0){
                Record r = new Record(i, 0, arrays[i][0]);
                queue.add(r);
            }
            
        }


        int[] ans = new int[limit];

        if(limit==0){
            return ans;
        }
    
        int index = 0;


        while(!queue.isEmpty()){
            Record r = queue.poll();
            if(index<limit){
                ans[index]= r.val;
            }
            
            index++;

            if(r.col+1<arrays[r.row].length){
                queue.add(new Record(r.row, r.col+1, arrays[r.row][r.col+1]));
            }
        }

        return ans;

        
    }
}


class Record{
    public int row;
    public int col;
    public int val;

    public Record(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}