import java.util.Stack;

/**
 * Created by Wangzf5 on 2017/3/10.
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    private int min = Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node);

        if (node < min) {
            min = node;
        }
        minStack.push(min);
    }

    public void pop() {
        stack.pop();

        minStack.pop();
        min = min();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
