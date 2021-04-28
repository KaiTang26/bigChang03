class Solution {
    public int compareVersion(String version1, String version2) {

        String[] v1Str = version1.split("\\.");
        String[] v2Str = version2.split("\\.");

        int v1Len = v1Str.length;
        int v2Len = v2Str.length;

        for(int i=0; i<Math.max(v1Len, v2Len); i++){
            int v1 = i>=v1Len?0:Integer.parseInt(v1Str[i]);
            int v2 = i>=v2Len?0:Integer.parseInt(v2Str[i]);
            if(v1>v2){
                return 1;
            }
            if(v2>v1){
                return -1;
            }
        }

        return 0;
    }
}