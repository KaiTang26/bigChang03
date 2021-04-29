class Solution {
    public int myAtoi(String s) {


        s=s.trim();
        int sign = 1;
        int i = 0;
        int result = 0;

        if(!Character.isDigit(s.charAt(0)) && (s.charAt(0)!='-'||s.charAt(0)!='+') ){
            return 0;

        }

        if(!Character.isDigit(s.charAt(0))){
            
            if(s.charAt(0)=='-'){
                sign = -1;
            }
            i=1;
        }


        while(i<s.length()){
            char c = s.charAt(i);

            if(Character.isDigit(c)){

                result =result*10+(c-0);
            }
            i++;
        }


        return result*sign;
        
    }
}