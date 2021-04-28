import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {

        Map<Character, Boolean> map = new HashMap<>();

        char[] chars = s.toCharArray();

        for(int i=0; i<chars.length; i++){
                
            if(map.containsKey(chars[i])){
                map.put(chars[i], true);
            }else{
                map.put(chars[i], false);
            }
        }

        for(int i=0; i<chars.length; i++){

            if(!map.get(chars[i])){
                return i;
            }
        }

        return -1;
        
    }
}