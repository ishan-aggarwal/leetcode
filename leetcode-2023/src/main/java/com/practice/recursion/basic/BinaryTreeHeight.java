package com.practice.recursion.basic;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class BinaryTreeHeight {

    @Getter
    @Setter
    @Data
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node rootLeft = new Node(5);
        Node rootRight = new Node(15);

        Node rootLeftLeft = new Node(1);
        root.setLeft(rootLeft);
        root.setRight(rootRight);

        rootLeft.setLeft(rootLeftLeft);

        System.out.println(height(root));

    }

    private static int height(Node root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
