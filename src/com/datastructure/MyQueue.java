package com.datastructure;

public class MyQueue {
    int Max = 1000;
    int front;
    int rear;
    int[] queue;

    public MyQueue() {
        front = rear = 0;
        queue = new int[Max];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        if (rear == Max) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return rear - front;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("queue is full.");
            return;
        }
        queue[rear++] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("queue is empty.");
            return -1;
        }
        int item = queue[front];
        queue[front++] = 0;
        return item;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(3);
        myQueue.push(2);
        myQueue.push(1);
        System.out.println(myQueue.size());
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.push(3);
        myQueue.push(2);
        myQueue.push(1);
        myQueue.push(3);
        myQueue.push(2);
        myQueue.push(1);
    }
}
