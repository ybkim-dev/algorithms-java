package com.datastructure;

import java.util.ArrayList;
/*
public class MyStack<T> {
    private ArrayList<T> stack = new ArrayList<T>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if(stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<>();
        ms.push(1);
        ms.push(2);
        System.out.println(ms.pop());
    }
}
*/

public class MyStack {
    private int top;
    private int size;
    private int[] stack;

    public MyStack(int size) {
        this.size = size;
        this.top = -1;
        stack = new int[size];
    }

    public void push(int item) {
        stack[++top]= item;
    }
    public int pop(){
        int item = stack[top];
        stack[top--] = 0;
        return item;
    }

    public static void main(String[] args){
        MyStack myStack = new MyStack(6);
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);
        myStack.pop();
        myStack.pop();
    }
}