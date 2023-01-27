package com.practice.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/
public class StockSpanner {
    Stack<int[]> stack = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }

        stack.push(new int[]{price, ans});
        return ans;
    }

    public static void main(String[] args) {

        StockSpanner stockSpanner = new StockSpanner();
        List<Integer> res = new ArrayList<>();
        res.add(stockSpanner.next(100));
        res.add(stockSpanner.next(80));
        res.add(stockSpanner.next(60));
        res.add(stockSpanner.next(70));
        res.add(stockSpanner.next(60));
        res.add(stockSpanner.next(75));
        res.add(stockSpanner.next(85));

        System.out.println(res);
    }
}
