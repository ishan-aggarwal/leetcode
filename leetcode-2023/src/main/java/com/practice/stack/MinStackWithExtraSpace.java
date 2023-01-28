package com.practice.stack;

import java.util.Stack;

public class MinStackWithExtraSpace {

    public static void main(String[] args) {
        int[] arr = new int[]{18, 19, 29, 15, 16};
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(18);
        System.out.println("Minimum so far after putting 18: " + myStack1.minElement());
        myStack1.push(19);
        System.out.println("Minimum so far after putting 19: " + myStack1.minElement());
        myStack1.push(29);
        System.out.println("Minimum so far after putting 29: " + myStack1.minElement());
        myStack1.push(15);
        myStack1.push(16);
        System.out.println("Top element of the stack after recently inserting 15, 16: " + myStack1.top());
        System.out.println("Minimum so far after putting 15,16: " + myStack1.minElement());
        System.out.println("Pop the top most element from the stack: " + myStack1.pop());
        System.out.println("Top element of the stack after recently removing 16: " + myStack1.top());
        System.out.println("Minimum so far after removing 16: " + myStack1.minElement());
        System.out.println("Pop the top most element from the stack: " + myStack1.pop());
        System.out.println("Top element of the stack after recently removing 15: " + myStack1.top());
        System.out.println("Minimum so far after removing 15: " + myStack1.minElement());
    }


    static class MyStack1 {

        private Stack<Integer> stack;
        private Stack<Integer> helperStack;

        public MyStack1() {
            this.stack = new Stack<>();
            this.helperStack = new Stack<>();
        }

        public void push(int ele) {
            stack.push(ele);
            if (helperStack.isEmpty() || ele <= helperStack.peek()) {
                helperStack.push(ele);
            }
        }

        public int pop() {
            if (stack.isEmpty()) return -1;
            int ele = stack.peek();
            if (!helperStack.isEmpty() && helperStack.peek() == ele) {
                helperStack.pop();
            }
            return stack.pop();
        }

        public int top() {
            if (stack.isEmpty()) return -1;
            return stack.peek();
        }

        public int minElement() {
            if (helperStack.isEmpty()) {
                return -1;
            }
            return helperStack.peek();
        }
    }
}
