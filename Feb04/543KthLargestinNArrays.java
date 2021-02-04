import java.util.PriorityQueue;

public class Solution {
    /**
     * @param arrays: a list of array
     * @param k: An integer
     * @return: an integer, K-th largest element in N arrays
     */




    public int KthInArrays(int[][] arrays, int k) {
        // write your code here

        

        Comparator<Record> customComparator = new Comparator<Record>() {
            @Override
            public int compare(Record a, Record b) {
                return b.val-a.val;
            }
        };

        PriorityQueue<Record> pq = new PriorityQueue<>(customComparator);

        for(int i=0; i<arrays.length; i++){

            int len = arrays[i].length;
            if(len>0){
                Arrays.sort(arrays[i]);
                Record r = new Record(i, len-1, arrays[i][len-1]);
                pq.offer(r);
            }
        }

        int count =0;

        while(!pq.isEmpty()){

            Record rd = pq.poll();
            count++;
            if(count==k){
                return rd.val;
            }
            if(rd.col-1>=0){

                Record r = new Record(rd.row, rd.col-1, arrays[rd.row][rd.col-1]);
                pq.offer(r);
            }
        }

        return -1;
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