public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        /*
        * Input: s = "abcabcbb"
        * Output: 3
        * Explanation: The answer is "abc", with the length of 3. 
        */

        char[] chars = s.toCharArray();
        Set<Character> isRepeat = new HashSet<>();
        int j = 0;
        int ans = 0;
        for(int i=0; i<chars.length; i++){
            while(j<chars.length){
                if(isRepeat.add(chars[j])){
                    ans = Math.max(isRepeat.size(), ans);
                    j++;
                }else{
                    isRepeat.remove(chars[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
