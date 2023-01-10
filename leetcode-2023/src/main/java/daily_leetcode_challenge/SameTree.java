package daily_leetcode_challenge;

public class SameTree {

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

        root1 = new TreeNode(1);
        root2 = new TreeNode(1);
        root1.setLeft(new TreeNode(2));

        System.out.println(isSameTree(root1, root2));

    }

}
