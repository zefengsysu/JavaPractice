/**
 * Created by Wangzf5 on 2017/3/1.
 */
public class Stack {
    private int size = 10;
    private int[] stack;
    private int[] minStack;

    private int count = 0;
    private int min = Integer.MAX_VALUE;

    public Stack() {
        stack = new int[size];
        minStack = new int[size];
    }

    public Stack(int size) {
        this.size = size;
        stack = new int[this.size];
        minStack = new int[this.size];
    }

    public void push(int value) throws Exception {
        if (count < size) {
            stack[count] = value;
            if (value < min) {
                min = value;
            }
            minStack[count++] = min;
        } else {
            throw new Exception("Stack is full");
        }
    }

    public int pop() throws Exception {
        if (count > 0) {
            return stack[--count];
        } else {
            throw new Exception("Stack is empty");
        }
    }

    public int min() throws Exception {
        if (count > 0) {
            return minStack[count - 1];
        } else {
            throw new Exception("Stack is empty");
        }
    }
}
