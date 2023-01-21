package com.practice.recursion.basic;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack == null || stack.size() <= 1)  return;

        int top = stack.pop();
        reverse(stack);

        insert(stack, top);
    }

    private static void insert(Stack<Integer> stack, int top) {
        if (stack.isEmpty()) {
            stack.push(top);
            return;
        }

        int currentTop = stack.pop();
        insert(stack, top);
        stack.push(currentTop);
    }
}
