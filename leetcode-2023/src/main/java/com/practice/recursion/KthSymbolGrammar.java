package com.practice.recursion;

public class KthSymbolGrammar {

    public static void main(String[] args) {
        System.out.println(kthGrammar(4, 6));
    }

    public static int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) return 0;
        int midPos = (1 << (n - 1)) / 2;

        if (k <= midPos) {
            return kthGrammar(n - 1, k);
        } else {
            return kthGrammar(n - 1, k - midPos) ^ 1;
        }
    }
}