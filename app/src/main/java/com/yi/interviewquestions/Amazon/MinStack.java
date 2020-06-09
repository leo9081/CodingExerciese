package com.yi.interviewquestions.Amazon;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s;
    Stack<Integer> m;

    /** initialize your data structure here. */
    public MinStack() {
        s= new Stack<Integer>();
        m = new Stack<Integer>();
    }

    public void push(int x) {
        s.push(x);
        if(m.isEmpty()) m.push(x);
        else if(m.peek() >= x) m.push(x);
    }

    public void pop() {
        int t = s.pop();
        if(m.peek() == t) m.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return m.peek();
    }
}
