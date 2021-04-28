import org.graalvm.compiler.nodes.calc.IntegerLessThanNode.LessThanOp;

class Solution {
    public String numberToWords(int num) {

        String ans = "";
        

        int billion = num/1000000000;

        int million = (num-billion*1000000000)/1000000;

        int thousand = (num-billion*1000000000-million*1000000)/1000;

        int rest = (num-billion*1000000000-million*1000000-thousand*1000);

        if(billion!=0){
            ans = zeroToNine(billion)+" Billion";
        }

        if(million!=0){
            ans += handleThreeDigit(million) + " Million";
        }

        if(thousand!=0){
            ans += handleThreeDigit(million) + " Thousand";
        }

        if(rest!=0){
            ans += handleThreeDigit(million);
        }


        return ans;
        
    }


    public String zeroToNine(int num){

        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    public String twoLessThan20(int num) {
        switch(num) {
          case 10: return "Ten";
          case 11: return "Eleven";
          case 12: return "Twelve";
          case 13: return "Thirteen";
          case 14: return "Fourteen";
          case 15: return "Fifteen";
          case 16: return "Sixteen";
          case 17: return "Seventeen";
          case 18: return "Eighteen";
          case 19: return "Nineteen";
        }
        return "";
      }

      public String ten(int num) {
        switch(num) {
          case 2: return "Twenty";
          case 3: return "Thirty";
          case 4: return "Forty";
          case 5: return "Fifty";
          case 6: return "Sixty";
          case 7: return "Seventy";
          case 8: return "Eighty";
          case 9: return "Ninety";
        }
        return "";
      }

    public String handleTwoDigit(int num){

        if(num==0){
            return "";
        }else if(num<10){
            return zeroToNine(num);
        }else if(num<20){
            return twoLessThan20(num);
        }else{
            int t = num/10;
            int rest = num - t*10;
            if(rest==0){
                return ten(t);
            }else{
                return ten(t)+" "+zeroToNine(rest);
            }
        }
    }

    public String handleThreeDigit(int num){
        String result = "";

        int h = num/100;
        int rest = num-h*100;

        if(h*rest!=0){
            result = zeroToNine(h)+" Hundred "+handleTwoDigit(rest);
            return result;
        }

        if(h==0 && rest !=0){
            result = handleTwoDigit(rest);
            return result;
        }

        if(h!=0 && rest ==0){
            result = zeroToNine(h)+" Hundred";
            return result;
        }

        return result;
    }
}