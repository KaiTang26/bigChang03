import java.util.HashSet;

public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here\
        // O(n3)

        if(s==null || s.length()==0){
            return 0;
        }


        char[] chars = s.toCharArray();

        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<chars.length; i++){

            
            for(int j=i; j<chars.length; j++){
                Set<Character> isRepeat = new HashSet<Character>();
                for(int k=i; k<=j; k++){
                    if(isRepeat.add(chars[k])){
                        maxLen = Math.max(isRepeat.size(), maxLen);
                    }else{
                        break;
                    }

                }
            }
        }

        return maxLen;


    }
}

public class Solution2 {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        // O(n2)

        if(s==null || s.length()==0){
            return 0;
        }


        char[] chars = s.toCharArray();

        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<chars.length; i++){
            Set<Character> isRepeat = new HashSet<Character>();

            
            for(int j=i; j<chars.length; j++){
                
               
                    if(isRepeat.add(chars[j])){
                        maxLen = Math.max(isRepeat.size(), maxLen);
                    }else{
                        break;
                    }

            }
        }

        return maxLen;


    }
}

public class Solution3 {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        // O(n2)

        if(s==null || s.length()==0){
            return 0;
        }


        char[] chars = s.toCharArray();

        int maxLen = Integer.MIN_VALUE;

        Set<Character> isRepeat = new HashSet<Character>();

        int j = 0;

        for(int i=0; i<chars.length; i++){


            while(j<chars.length){
                if(isRepeat.add(chars[j])){
                    maxLen = Math.max(isRepeat.size(), maxLen);
                    j++;
                }else{
                    isRepeat.remove(chars[i]);
                    break;
                }
            }
            
        }

        return maxLen;


    }
}
