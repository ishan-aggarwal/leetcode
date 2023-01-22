package com.practice.recursion;

public class TowerOfHanoi {

    // Statement:
    // There are 3 towers A, B and C
    // There are N disks places on tower A (src) and need to be shifted to tower C (destination) using B (temp)
    // Making sure that at no point a smaller disk is below a longer disk
    // Finally you need to print all the steps taken for this movement.

    public static void main(String[] args) {


        toh(3, "A", "B", "C");

    }

    public static void toh(int n, String src, String temp, String dest) {
        // base case
        if (n == 0) return;

        // to start with we assume that our function works
        // and we want to move (n-1) disks from src to intermediate (temp) making use of destination
        toh(n - 1, src, dest, temp);
        // since destination is now empty and largest disk is still on src
        // so we print the movement of disk n from src to destination directly.
        System.out.println("Moving : " + n + " from " + src + " to " + dest);
        // now what we need to do is move the (n-1) disks that are left from intermediate (temp) to destination making use of empty src.
        toh(n - 1, temp, src, dest);
    }
}
