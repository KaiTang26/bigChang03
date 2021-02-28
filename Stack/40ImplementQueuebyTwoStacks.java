import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        // do intialization if necessary
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        s1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(s2.isEmpty()){
            transfer();
        }
        

        return s2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if(s2.isEmpty()){
            transfer();
        }

        return s2.peek();
    }

    public void transfer(){

        while(!s1.isEmpty()){

            s2.push(s1.pop());
        }
    }
}
