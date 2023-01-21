package com.practice.recursion.basic;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(0);
        stack.push(10);

        int middle = (stack.size() + 1) / 2;

        System.out.println(stack);
        delete(stack, middle);
        System.out.println(stack);
    }

    private static void delete(Stack<Integer> stack, int middle) {

        if (stack.isEmpty()) {
            return;
        }

        if (middle == 1) {
            stack.pop();
            return;
        }

        int top = stack.pop();
        delete(stack, middle - 1);
        stack.push(top);
    }
}
