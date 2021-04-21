public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here

		int base = 100000;

		int seed = 31;

		int targetLen = target.length();

		int power = 0;

		for(int i=0; i<targetLen; i++){
			power = (power*31)%base;
		}

		int targetValue = 0;

		for(int i=0; i<targetLen; i++){
			targetValue = (targetLen*seed+target.charAt[i])%base;
		}


		int hashValue = 0;


		for(int i =0; i<source.length(); i++){

			hashValue = (hashValue*seed+source.charAt(i))%base;

			if(i>=targetLen){

				hashValue = hashValue -(source.charAt(i-targetLen)*power)%base;

				if(hashValue<0){
					hashValue +=base;
				}
			}

			if(hashValue==targetLen && target.equals(source.substring(i-targetLen+1, i+1))){
				return i-targetLen+1;
			}


		}

		return -1;

		

		
    }


}