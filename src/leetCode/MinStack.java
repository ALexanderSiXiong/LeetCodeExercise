package leetCode;

import java.util.Stack;

public class MinStack {
    // 思路：
    // 每一次push两个值进去
    // 上一轮的最小值和这一轮的值

    // 那么，在待会儿pop的时候，一旦pop遇到的最小值，就要pop两次
    // 第二次pop重新赋值min

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {


        // 注意这个地方边界 是小于等于；
        // 如果不是小于等于，那么在第二次push进一个最小值的时候，只会进入一个值；在下一次pop的时候，删除两个值，且重新赋值最小值的时候会把值assign给另外一个不一定是最小值的数

        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.peek() == min){
            stack.pop();
            min = stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


/**
 * The MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */