class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> valueStack;
    private Stack<Integer> minValueStack;

    public MinStack() {
        valueStack  = new Stack<>();
        minValueStack = new Stack<>();
        
    }
    
    public void push(int x) {

        valueStack.push(x);

        if(valueStack.isEmpty()){  
            minValueStack.push(x);
        }else{
            int minValue = Math.min(x, minValueStack.top());
            minValueStack.push(minValue);
        }
        
    }
    
    public void pop() {

        if(!valueStack.isEmpty()){
            valueStack.pop();
            minValueStack.pop();
        }
        
    }
    
    public int top() {

        if(!valueStack.isEmpty()){
            return valueStack.top();
        }

        return -1;
        
    }
    
    public int getMin() {

        if(!minValueStack.isEmpty()){
            return minValueStack.top();
        }

        return -1;


        
    }
}
