package daily_leetcode_challenge;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// Root , Left , Right
public class BinaryTreePreOrderTraversal {


//    Let n be the number of nodes in the tree.
//
//    Time complexity: O(n)
//    We use a stack to store all nodes to be visited. Each of the n nodes is added to and popped from the stack once, which takes O(1) time.
//    All other work done at each node is O(1), so the overall time complexity is O(n).
//
//    Space complexity: O(n)
//    We use a stack to store all the nodes to be visited. Similar to the previous approach, the stack takes up space equivalent to the depth of the tree.
//    The max depth of the tree could be O(n) in the worst-case scenario when the tree is skewed.

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        // base condition check if root is null
        if (root == null) {
            return result;
        }

        // push root in the stack
        stack.push(root);

        // do while stack has more elements
        while (!stack.isEmpty()) {
            // pop the top most element from the stack
            TreeNode node = stack.pop();
            // add the data to results
            result.add(node.val);

            // if right node is present, push it into the stack first
            // so that during pop operation first left subtree gets processed
            if (node.right != null) {
                stack.push(node.right);
            }

            // if left node is present, push it into the stack
            // so that during pop operation left subtree gets processed first
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));

        (root.getLeft()).setLeft(new TreeNode(4));
        (root.getLeft()).setRight(new TreeNode(5));
        System.out.println(preorderTraversal(root));
    }
}