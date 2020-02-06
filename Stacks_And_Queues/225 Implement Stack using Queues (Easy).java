/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

思路:
create a queue
after x added in the last of the queue, remove the first element and add it to end of the queue, and then remove the second
element and add it to the end of the queque, till the x becomes the first element in the queue(queue.size() - 1 times)

难点:
0.怎么实现Queue?

所用API:
Queue<Integer> queue = new LinkedList<>();
queue.add(x);
queue.poll();
queue.peek();
queue.isEmpty();
queue.size();
*/

class MyStack {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
