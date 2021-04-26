class Solution {
    public int myAtoi(String str) {

        str = str.replaceAll("\\s+", "");

        char[] strChars = str.toCharArray();

        for(char c : strChars){
            System.out.println(c);
        }

        return 0;
        
    }
}
