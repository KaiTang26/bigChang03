import java.util.Stack;

public class Solution {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here

        Stack<Object> stack = new Stack<>();

        int num = 0;

        for(char c : s.toCharArray()){

            if(Character.isDigit(c)){
                num = num*10+(c-'0');   // for case like number greater than 10
            }else if(c=='['){
                stack.push(Integer.valueOf(num));
                num=0;
            }else if(c==']'){
                String rebuiltString = helper(stack);
                Integer count = (Integer)stack.pop();

                for(int i=0; i<count; i++){
                    stack.push(rebuiltString);
                }
            }else{
                stack.push(String.valueOf(c));
            }
        }

        return helper(stack);
    }

    public String helper(Stack<Object> stack){

        Stack<String> temp = new Stack<>();

        while(!stack.isEmpty() && stack.peek() instanceof String){
            temp.push((String)stack.pop());
        }

        String ans = "";
        while(!temp.isEmpty()){

            ans+=temp.pop();
        }
        return ans;
    }
}
