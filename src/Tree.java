/**
 * Created by Wangzf5 on 2017/3/1.
 */
public class Tree extends TreeNode {
    public TreeNode head = null, tail = null;

    public Tree(int value, TreeNode leftSubTree, TreeNode rightSubTree) {
        super(value, leftSubTree, rightSubTree);
    }

    public void tree2List(TreeNode current, TreeNode left, TreeNode right) {
        if (current == null) {
            return;
        }
        if (!hasSubTree(current)) {
            if (left != null && right == null) {
                current.leftSubTree = left;
                tail = current;
                return;
            }
            if (left == null && right != null) {
                current.rightSubTree = right;
                head = current;
            }
            return;
        }

        if (current.leftSubTree != null) {
            if (left != null) {
                left.rightSubTree = current.leftSubTree;
                if (!hasSubTree(current.leftSubTree)) {
                    current.leftSubTree.leftSubTree = left;
                    current.leftSubTree.rightSubTree = current;
                } else {
                    tree2List(current.leftSubTree, left, current);
                }
            } else {
                tree2List(current.leftSubTree, null, current);
            }
        }
        if (current.rightSubTree != null) {
            if (right != null) {
                right.leftSubTree = current.rightSubTree;
                if (!hasSubTree(current.rightSubTree)) {
                    current.rightSubTree.leftSubTree = current;
                    current.rightSubTree.rightSubTree = right;
                } else {
                    tree2List(current.rightSubTree, current, right);
                }
            } else {
                tree2List(current.rightSubTree, current, null);
            }
        }

        if (head != null) {
            head.leftSubTree = tail;
        }
        if (tail != null) {
            tail.rightSubTree = head;
        }
    }

    public int findMax() {
        return findMax(this).value;
    }

    public static TreeNode findMax(TreeNode treeNode) {
        if (treeNode != null) {
            treeNode.rightSubTree = treeNode.leftSubTree;
            /*while (treeNode.rightSubTree != null) {
                treeNode = treeNode.rightSubTree;
            }*/
        }

        return  treeNode;
    }


    private boolean hasSubTree(TreeNode root) {
        return root.leftSubTree != null || root.rightSubTree != null;
    }

}
