package daily_leetcode_challenge;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

//    Time complexity : O(N) since each node is visited exactly once.
//
//    Space complexity : O(N) in the worst case, where the tree is a perfect fully balanced binary tree,
//    since BFS will have to store at least an entire level of the tree in the queue, and the last level has O(N) nodes.


    public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode one = queue.poll();
            TreeNode two = queue.poll();
            if (one == null && two == null) {
                continue;
            }
            if (one == null || two == null || one.val != two.val) {
                return false;
            }
            queue.offer(one.left);
            queue.offer(two.left);
            queue.offer(one.right);
            queue.offer(two.right);
        }
        return true;
    }


//    Time complexity : O(N), where N is a number of nodes in the tree, since one visits each node exactly once.
//    Space complexity : O(N) in the worst case of completely unbalanced tree, to keep a recursion stack.

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return
                p.val == q.val
                        && isSameTree(p.left, q.left)
                        && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);

        System.out.println(isSameTree(root1, root2));
        System.out.println(isSameTree1(root1, root2));

        root1 = new TreeNode(1);
        root2 = new TreeNode(1);
        root1.setLeft(new TreeNode(2));

        System.out.println(isSameTree(root1, root2));
        System.out.println(isSameTree1(root1, root2));


    }

}
