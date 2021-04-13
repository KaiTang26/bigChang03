import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int finalInstances(int instances, int[] averageUtil) {

        int currentInstances = instances;

        for(int i=0; i<averageUtil.length; i++){

            int util = averageUtil[i];

            if(util>60 && currentInstances*2 <200000000){
                currentInstances = currentInstances*2;
                i+=10;
            }else if(util<25 && (currentInstances+1)/2>1){
                currentInstances = (currentInstances+1)/2;
                i+=10;
            }
        }

        return currentInstances;

       

    }
}

