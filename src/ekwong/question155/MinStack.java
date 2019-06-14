package ekwong.question155;


import java.util.LinkedList;
import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *
 * @author ekwong
 */
public class MinStack {

    private Stack<Integer> stack;
    private LinkedList<Integer> minList;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minList = new LinkedList<>();
        minList.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        if (minList.getFirst() >= x) {
            stack.push(x);
            minList.addFirst(x);
        } else {
            stack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minList.getFirst())) {
            minList.removeFirst();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minList.getFirst();
    }
}
