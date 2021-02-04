import java.util.PriorityQueue;

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int len = matrix[0].length;


        Comparator<Record> customComparator = new Comparator<Record>() {
            @Override
            public int compare(Record a, Record b) {
                return a.val-b.val;
            }
        };

        PriorityQueue<Record> pq = new PriorityQueue<>(customComparator);


        for(int i=0; i<matrix.length; i++){
            Record r = new Record(i, 0, matrix[i][0]);
            pq.offer(r);
        }

        int count = 0;


        while(!pq.isEmpty()){

            Record rd = pq.poll();
            count++;

            if(count==k){
                return rd.val;
            }

            if(rd.col+1<len){
                Record r = new Record(rd.row, rd.col+1, matrix[rd.row][rd.col+1]);
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
