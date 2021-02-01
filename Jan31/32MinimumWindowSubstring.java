import java.util.Map;

public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here

       if(source.length()==0||target.length()==0){
           return "";
       }

        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        

        char[] sArray = source.toCharArray();
        int len = sArray.length;

        for(char i: target.toCharArray()){
            addToMap(tMap, i);
        }


        int minLen = Integer.MAX_VALUE;
        int minStart=0;
        int minEnd = 0;


        for(int i=0; i<len; i++){

            Map<Character, Integer> subMap = new HashMap<Character, Integer>();
            for(int j=i; j<len; j++){
               addToMap(subMap, sArray[j]);
               if(isContains(tMap, subMap)){
                    if(j-i+1<minLen){
                        minLen = j-i+1;
                        minStart=i;
                        minEnd=j;
                        break;
                    }
               }
            }
        }


        if(minLen!=Integer.MAX_VALUE){
            return source.substring(minStart, minEnd+1);
        }else{
            return "";
        }


        

    }


    public void addToMap(Map<Character, Integer> map, char c){

        if(map.containsKey(c)){
            map.put(c, map.get(c)+1);
         }else{
            map.put(c, 1);
         }

    }

    public boolean isContains(Map<Character, Integer> tMap, Map<Character, Integer> subMap){

        if(subMap.size()<tMap.size()){
            return false;
        }

        for(char key : tMap.keySet()){

            if(!subMap.containsKey(key) || tMap.get(key)>subMap.get(key)){
                return false;
            }
        }

        return true;

    }
}


public class Solution2 {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here

       if(source.length()==0||target.length()==0){
           return "";
       }

        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        

        char[] sArray = source.toCharArray();
        int len = sArray.length;

        for(char i: target.toCharArray()){
            addToMap(tMap, i);
        }


        int minLen = Integer.MAX_VALUE;
        int minStart=0;
        int minEnd = 0;

        Map<Character, Integer> subMap = new HashMap<Character, Integer>();

        int j=0;


        for(int i=0; i<len; i++){

            while(!isContains(tMap, subMap)){

                if(j<len){
                    addToMap(subMap, sArray[j]);
                    j++;

                }else{
                    break;
                }
            }

            if(isContains(tMap, subMap) && j-i<minLen){
                minLen = j-i;
                minStart=i;
                minEnd=j;
            }
            
            removeFromMap(subMap, sArray[i]);


        }


        if(minLen!=Integer.MAX_VALUE){
            return source.substring(minStart, minEnd);
        }else{
            return "";
        }

    }

    public void removeFromMap(Map<Character, Integer> map, char c){
        int count = map.get(c);
        if(count>1){
            map.put(c, map.get(c)-1);
        }else{
            map.remove(c);
        }
    }


    public void addToMap(Map<Character, Integer> map, char c){

        if(map.containsKey(c)){
            map.put(c, map.get(c)+1);
         }else{
            map.put(c, 1);
         }

    }

    public boolean isContains(Map<Character, Integer> tMap, Map<Character, Integer> subMap){

        if(subMap.size()<tMap.size()){
            return false;
        }

        for(char key : tMap.keySet()){

            if(!subMap.containsKey(key) || tMap.get(key)>subMap.get(key)){
                return false;
            }
        }

        return true;

    }
}