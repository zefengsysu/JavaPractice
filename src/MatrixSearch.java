import java.util.ArrayList;

/**
 * Created by Wangzf5 on 2017/3/8.
 */
public class MatrixSearch {
    public static boolean Find(int target, int [][] array) {
        if (array != null) {
            int rows = array.length - 1, columns = array[0].length - 1;
            int row = array.length - 1, column = 0;

            while (row >= 0 && row <= rows && column >= 0 && column <= columns &&
                    array[row][column] != target) {
                if (array[row][column] > target) {
                    row--;
                } else {
                    column++;
                }
            }
            if ((row >= 0 && row <= rows && column >= 0 && column <= columns &&
                    array[row][column] == target)) {
                return true;
            }
        }
        return false;
        /*if (array != null) {
            for (int[] a : array) {
                if (binarySearch(target, a)) {
                    return true;
                }
            }
        }

        return false;*/
    }

    private static boolean binarySearch(int target, int[] array) {
        int start = 0, end = array.length - 1;
        int middle = (end - start) / 2;

        while (start != end && array[middle] != target) {
            if (array[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }

            middle = start != end ? (end - start) / 2 : start;
        }
        if (array[middle] == target) {
            return true;
        }

        return false;
    }

    // 变态跳台阶
    public static int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 1; i < target; i++) {
            result += JumpFloorII(target - i);
        }

        return result;
    }

    // 替换空格
    public static String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        String resource = str.toString();
        int length = resource.length();
        char ch;

        for (int i = 0; i < length; i++) {
            ch = resource.charAt(i);
            if (ch != ' ') {
                result.append(ch);
            } else {
                result.append("%20");
            }
        }

        return result.toString();
    }

    // 链表反转输出
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> temp = new ArrayList<Integer>();

        while (listNode != null) {
            temp.add(listNode.val);
            listNode = listNode.next;
        }

        int length = temp.size();
        if (length != 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();

            for (int i = length - 1; i >= 0; i--) {
                result.add(temp.get(i));
            }

            temp = null;
            return result;
        }

        return null;
    }


    // 前序 中序数组 求 二叉树
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length, 0, in.length);
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in, int preBegin, int preEnd, int inBegin, int inEnd) {
        int length = preEnd - preBegin;
        if (length != 0) {
            int rootVal = pre[preBegin];

            int index = inBegin;
            while (in[index++] != rootVal);

            TreeNode tree = new TreeNode(rootVal);
            tree.left = reConstructBinaryTree(pre, in, preBegin + 1, preBegin + (index - inBegin),
                    inBegin, index - 1);
            tree.right = reConstructBinaryTree(pre, in, preBegin + (index - inBegin), preEnd, index, inEnd);

            return tree;
        }

        return null;
    }

    public static void main(String[] args) {
        /*System.out.print(Find(7,
                new int[][]{{1, 2, 8, 9, 10},
                            {2, 4, 9, 12, 13},
                            {4, 7, 10, 13, 14},
                            {6, 8, 11, 15, 16}}));*/

        /*System.out.print(JumpFloorII(4));*/

        /*System.out.print(replaceSpace(new StringBuffer("We Are Happy")));*/

        TreeNode tree = reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }
}
