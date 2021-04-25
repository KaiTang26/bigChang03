package AmazonVO;

public class hashFunc {


    public int hash(String str){

        int seed = 31;
        int base = 1000000;

        int hashValue = 1;

        for(char c :str.toCharArray()){
            hashValue = (hashValue*seed+c)%base;
        }

        return hashValue;
    }
    
}
