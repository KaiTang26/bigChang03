import java.util.concurrent.ArrayBlockingQueue;

public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
 

public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<Event> events = new ArrayList<>();

        for(Integer I : airplanes){

            events.add(new Event(I.start, false));
            events.add(new Event(I.end, true));
        }

        Collections.sort(events, (a,b)->{

            if(a.time==b.time){
                if((a.isLanding && b.isLanding)||(!a.isLanding && !b.isLanding)){
                    return 0;
                }else if(a.isLanding ){
                    return -1;
                }else{
                    return  1;
                }
            }
            return a.time-b.time;

        });

        int count = 0;
        int ans = Integer.MIN_VALUE;


        for(Event e: events){

            if(!e.isLanding){
                count +=1;
            }else{
                count -=1;
            }

            ans = Math.max(cout, ans);

           
        }

        return ans;
    }
}

class Event{
    int time;
    boolean isLanding;

    public Event(int time, boolean isLanding){
        this.time = time;
        this.isLanding = isLanding;
    }
}