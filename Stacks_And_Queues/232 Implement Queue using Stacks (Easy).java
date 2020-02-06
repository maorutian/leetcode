/* 3
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
*/

/*
思路:
Keep 2 stacks, let's call them inbox and outbox.
inbox is only for enqueue, outbox is only for dequeue
if enqueue: push onto inbox
if dequeue:
check if outbox is empty - is empty: transfer array from inbox to outbox, then pop
                         - is not empty: pop element in outbox
难点:
0.怎么实现stack?用new Stack<>()
import java.util.Stack;
Stack<Integer> inbox = new Stack<>(); 
1.如何翻转数组:
while (!inbox.isEmpty()) {outbox.push(inbox.pop());}
2.如何得到inbox Stack最底部(即最先进去)的数据
1)inbox.firstElement();
2)全翻转到outbox, 再outbox.peek()
优化:
1.采用inbo.firstElement()-37.3mb
2.采用全翻转到outbox, 再outbox.peek() - 37mb
3.由于peek()和pop()都会判断再outbox isempty, 代码复用 36.9mb
API:
Stack<Integer> inbox = new Stack<>(); 
inbox.push();
inbox.pop();
inbox.peek();
inbox.isEmpty();
inbox.firstElement();

*/

import java.util.Stack;

class MyQueue {
    private Stack<Integer> inbox;
    private Stack<Integer> outbox;

    /** Initialize your data structure here. */
    public MyQueue() {
        inbox = new Stack<>();
        outbox = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inbox.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
            return outbox.pop();

        } else {
            return outbox.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
            return outbox.peek(); //or return inbox.firstElement();
        } else {
            return outbox.peek();
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inbox.isEmpty() && outbox.isEmpty();

    }
}

class MyQueue2 {

    private Stack<Integer> inbox;
    private Stack<Integer> outbox;

    /** Initialize your data structure here. */
    public MyQueue2() {
        inbox = new Stack<>();
        outbox = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inbox.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        inboxTransferOutbox();
        return outbox.pop();
    }

    /** Get the front element. */
    public int peek() {
        inboxTransferOutbox();
        return outbox.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inbox.isEmpty() && outbox.isEmpty();

    }

    private void inboxTransferOutbox() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
    }

}
