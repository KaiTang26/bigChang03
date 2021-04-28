import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {


        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        


        int j=0;

        int countSub =0;

        int min =Integer.MAX_VALUE;
        String ans = "";

        for(int i=0; i<s.length(); i++){

            while(j<s.length() && countSub<t.length()){

                char c = s.charAt(j);
                if(map.containsKey(c)&&map.get(c)>0){
                    countSub++;
                    map.put(c, map.get(c)-1);
                }
               j++;
            }

            if(countSub>=t.length()&& j-i<min){
                min = j-i;
                ans = s.substring(i,j);
            }

            char addBack = s.charAt(i);
            if(map.containsKey(addBack)){
                countSub--;
                map.put(addBack, map.get(addBack)+1);

            }


        }

        return ans;
    }
}