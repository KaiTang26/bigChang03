import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {


        PriorityQueue<Record> pq = new PriorityQueue<>((a,b)->{

            if(a.time == b.time){
                // 
                if(!a.isStart){
                    return -1;
                }else if(!b.isStart){
                    return 1;
                }else {
                    return 0;
                }
            }
            return a.time = b.time;
        });


        for(int[] interval: intervals){
            pq.offer(new Record(interval[0], true));
            pq.offer(new Record(interval[1], false));
        }


        int currtentCount = 0;
        int maxCount = 0;

        while(!pq.isEmpty()){

            Record r = pq.poll();

            if(r.isStart){
                currtentCount++;
            }else{
                currtentCount--;
            }

            maxCount = Math.max(maxCount, currtentCount);
        }

        return maxCount;
        
    }
}


class Record{
    public int time;
    public boolean isStart;

    public Record(int time, boolean isStart){
        this.time = time;
        this.isStart = isStart;
    }
}