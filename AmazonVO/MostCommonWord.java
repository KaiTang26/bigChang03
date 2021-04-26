import java.util.Map;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> set = new HashSet<>(Arrays.asList(banned));
        String[] stringArray = paragraph.trim().split("\\W+");
        Map<String, Integer> map = new HashMap<>();
        String ans = null;
        int max = Integer.MIN_VALUE;


        for(String s: stringArray){

            if(set.contains(s)){
                continue;
            }

            int count = 1;

            if(map.containsKey(s)){
                count = map.get(s)+1;
                map.put(s, count);
            }else{
                map.put(s, count);
            }

            if(count>max){
                max = count;
                ans = s;
            }
        }

        return ans;


        
    }
}
