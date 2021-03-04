public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here

       
        double start = 0;
        double end = Math.max(x, 1);

        double ept = 1e-8;

        while(start+ept<end){
            double mid = start+(end-start)/2;
            if(mid*mid>x){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(end*end<=x){
            return end;
        }

        return start;

    }
}
