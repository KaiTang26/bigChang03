public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;


    public MinStack() {
        // do intialization if necessary
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here

        this.stack.push(number);

        if(!this.minStack.isEmpty()){
            int preMin = this.minStack.peek();

            if(number<preMin){
                this.minStack.push(number);
            }else{
                this.minStack.push(preMin);
            }

        }else{
            this.minStack.push(number);
        }
        
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here

        this.minStack.pop();
        return this.stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return this.minStack.peek();
    }
}