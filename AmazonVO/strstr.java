class Solution {
    public int strStr(String haystack, String needle) {

        int nLen = needle.length();
        int hLen = haystack.length();

        if(haystack==null || nLen>hLen){
            return -1;
        }

        if(haystack.equals(needle)||needle.equals("")){
            return 0;
        }

        int seed = 31;
        int base = 1000000;


        long needleValue =0;

        for(char c : needle.toCharArray()){
            needleValue = (needleValue*seed+c)%base;
        }

        long power =1;

        for(int i=0; i<nLen; i++){
            power = (power*seed)%base;
        }

        long hayValue = 0;

        for(int i=0; i<hLen; i++){

            char c = haystack.charAt(i);
            hayValue = (hayValue*seed+c)%base;

            if(i>=nLen){
                char removeC = haystack.charAt(i-nLen);
                hayValue = hayValue -(removeC*power)%base;

                if(hayValue<0){
                    hayValue = hayValue+base;
                }

            }

            if(hayValue==needleValue && haystack.substring(i-nLen+1,i+1).equals(needle)){
                return i-nLen+1;
            }

        }

        return -1;
    }
}



