import java.util.Map;

class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        char[] sChars = s.toCharArray();

        for(int i=0; i<sChars.length; i++){

            int value = map.get(sChars[i]);
            if(i+1<sChars.length){
                int nextValue = map.get(sChars[i+1]);

                if(nextValue>value){
                    sum = sum + nextValue-value;
                    i=i+1;
                    continue;
                }
                
            }
            sum+=value;
        }

        return sum;
        
    }
}
