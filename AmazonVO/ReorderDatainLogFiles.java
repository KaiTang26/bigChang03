class Solution {
    public String[] reorderLogFiles(String[] logs) {


        Arrays.sort(logs, (a, b)->{

            String[] aStrs = a.split(" ",2);
            String[] bStrs = b.split(" ",2);

            boolean aIsDigit = Character.isDigit(aStrs[1].charAt(0));
            boolean bIsDigit = Character.isDigit(bStrs[1].charAt(0));

            if(!aIsDigit && !bIsDigit){

                if(aStrs[1].compareTo(bStrs[1])!=0){
                    return aStrs[1].compareTo(bStrs[1]);
                }
                return aStrs[0].compareTo(bStrs[0]);
            }


            return 0;



        });


        return logs;
        
    }
}
