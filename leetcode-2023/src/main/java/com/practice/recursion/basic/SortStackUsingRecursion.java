package com.practice.recursion.basic;

import java.util.Stack;

public class SortStackUsingRecursion {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(0);

        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }

    private static void sort(Stack<Integer> stack) {
        if (stack == null || stack.size() <= 1) {
            return;
        }

        Integer top = stack.pop();
        sort(stack);
        insert(stack, top);
    }

    private static void insert(Stack<Integer> stack, Integer top) {
        if (stack.isEmpty() || stack.peek() <= top) {
            stack.push(top);
            return;
        }
        int temp = stack.pop();
        insert(stack, top);
        stack.push(temp);
    }
}
