import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wangzf5 on 2017/3/10.
 */
public class BinaryTreePrint {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> tracker;
        ArrayList<Integer> vals = new ArrayList<>();

        tracker = traverse(root, 0);
        for (Map.Entry entry : tracker.entrySet()) {
            Collection<Integer> nums = (Collection<Integer>) entry.getValue();
            if (vals != null) {
                vals.addAll(vals);
            }
        }

        return vals;
    }

    public HashMap<Integer, ArrayList<Integer>> traverse(TreeNode root, int key) {
        HashMap<Integer, ArrayList<Integer>> tracker = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> temp;

        if (root == null) {
            tracker.put(key, null);
            return tracker;
        }

        ArrayList<Integer> nodes = new ArrayList<>();
        nodes.add(root.val);
        tracker.put(key, nodes);
        nodes.clear();

        tracker.putAll(traverse(root.left, key + 1));

        temp = traverse(root.right, key + 1);
        for (Map.Entry entry : temp.entrySet())  {
            int currentKey = (int)entry.getKey();
            nodes = tracker.get(currentKey);

            Collection<Integer> vals = (Collection<Integer>) entry.getValue();
            if (vals != null) {
                nodes.addAll(vals);
            }

            tracker.put(currentKey, nodes);
        }

        return tracker;
    }

    public static void main(String[] args) {
        BinaryTreePrint b = new BinaryTreePrint();

        TreeNode A = b.new TreeNode(8);
        A.left = b.new TreeNode(8);
        A.right = b.new TreeNode(7);
        A.left.left = b.new TreeNode(9);
        A.left.right = b.new TreeNode(2);

        TreeNode B = b.new TreeNode(8);
        B.left = b.new TreeNode(9);
        B.right = b.new TreeNode(2);

        TreeNode root = b.new TreeNode(10);
        root.left = A;
        root.right = B;

        System.out.print(b.PrintFromTopToBottom(root));
    }
}
