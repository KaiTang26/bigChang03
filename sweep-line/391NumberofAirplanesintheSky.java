import java.awt.List;

public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<Record> eventTimes = new ArrayList<>(airplanes.size()*2);

        for(Interval i : airplanes){
            eventTimes.add(new Record(i.start, 1));
            eventTimes.add(new Record(i.end, -1));
        }

        Collections.sort(eventTimes, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {

                if(o1.time == o2.time){
                    return o1.event-o2.event;
                }
                return o1.time - o2.time;
            }
        });

        int count = 0;
        int ans = 0;

        for(int i=0; i<eventTimes.size(); i++){

            Record r = eventTimes.get(i);

            count += r.event;

            ans = Math.max(ans, count);
        }

        return  ans;

    }
}


class Record{
    int time;
    int event;

    Record(int t, int e){
        this.time = t;
        this.event = e;
    }
}
