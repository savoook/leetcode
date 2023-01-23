package leetCode.implementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    MyStack() {
    }

    void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size()-1; i++) {
            Integer first = queue.remove();
            queue.add(first);
        }
    }

    int pop() {
        return queue.remove();
    }

    int top() {
        return queue.peek();
    }

    boolean empty() {
        return queue.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */