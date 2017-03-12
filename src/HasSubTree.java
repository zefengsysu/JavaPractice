import java.util.ArrayList;

/**
 * Created by Wangzf5 on 2017/3/10.
 */
public class HasSubTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        ArrayList<TreeNode> nodes = findB(root1, root2);
        for (int i = 0, nodesLength = nodes.size(); i < nodesLength; i++) {
            if (isB(root2, nodes.get(i))) {
                return true;
            }
        }

        return false;
    }

    private boolean isB(TreeNode B, TreeNode node) {
        if (B == null) {
            return true;
        }
        if (node == null) {
            return false;
        }

        return B.val == node.val && isB(B.left, node.left) && isB(B.right, node.right);
    }

    public ArrayList<TreeNode> findB(TreeNode A, TreeNode B) {
        ArrayList<TreeNode> nodes = new ArrayList<>();

        if (A == null) {
            return nodes;
        }

        if (A.val == B.val) {
            nodes.add(A);
        }
        nodes.addAll(findB(A.left, B));
        nodes.addAll(findB(A.right, B));

        return nodes;
    }

    public static void main(String[] args) {
        HasSubTree o = new HasSubTree();

        TreeNode A = o.new TreeNode(8);
        A.left = o.new TreeNode(8);
        A.right = o.new TreeNode(7);
        A.left.left = o.new TreeNode(9);
        A.left.right = o.new TreeNode(2);

        TreeNode B = o.new TreeNode(8);
        B.left = o.new TreeNode(9);
        B.right = o.new TreeNode(2);

        System.out.print(o.hasSubtree(A, B));
    }
}
