import java.util.HashSet;
import java.util.Map;

// Time limit Exceeded
public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here

        if (s.length() == 0 || k == 0) {
            return 0;
        }
        int len = s.length();
        int maxSubLen = Integer.MIN_VALUE;
        char[] cArray = s.toCharArray();

        for(int i=0; i<len; i++){
            Set<Character> set = new HashSet<Character>();
            for(int j=i; j<len; j++){
                set.add(cArray[j]);
                if(set.size()<=k){
                    maxSubLen=Math.max(maxSubLen, j-i+1);
                }
            }
        }

        return maxSubLen;
    }
}



public class Solution2 {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here

        if (s.length() == 0 || k == 0) {
            return 0;
        }
        int len = s.length();
        int maxSubLen = Integer.MIN_VALUE;
        char[] cArray = s.toCharArray();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int j=0;

        for(int i=0; i<len; i++){

            while(j<len){


                if(map.containsKey(cArray[j])){
                    map.put(cArray[j], map.get(cArray[j])+1);
                }else{

                    if(map.keySet().size()>=k){
                        break;
                    }
                    map.put(cArray[j],1);
                }
                j++;
            }

            if(map.keySet().size()<=k){
                maxSubLen=Math.max(maxSubLen, j-i);
            }

            if(map.containsKey(cArray[i])){

                int count = map.get(cArray[i]);

                if(count>1){
                    map.put(cArray[i], count-1);
                    
                }else{
                    map.remove(cArray[i]);
                }

            }

            
        }

        return maxSubLen;
    }
}