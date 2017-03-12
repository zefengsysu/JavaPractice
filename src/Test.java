import java.util.*;

/**
 * Created by Wangzf5 on 2017/2/27.
 */
public class Test {

    public static void main(String args[]) {
        /*LinkList linkList = new LinkList();

        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        linkList.add(5);

        System.out.println("linklist:" + linkList.toString());

        linkList.reverseLinkedList();

        System.out.println("The reversed linklist:" + linkList.toString());*/

        /*System.out.println(HammingDistance.hammingDistance(1, 4));*/

        /*String[] res = KeyboardRow.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        for (String str : res) {
            System.out.print(str + " ");
        }*/

        /*System.out.print(FizzBuzz.fizzBuzz(15).toString());*/

        /*Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);
        System.out.println(i.equals(j));
        int a = 1, b = 1;
        System.out.println(a == b);*/

        /*List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        for (Integer integer : list) {
            System.out.println(integer);
        }
        *//*找出最大值*//*
        int max = Collections.max(list);
        System.out.println("最大的为:"+max);

        *//*用指定元素替换指定list中的元素*//*
        Collections.fill(list, 6);
        System.out.println("替换后:");
        for (Integer integer : list) {
            System.out.println(integer);
        }

        *//*找出某个list里某个元素的个数*//*
        int count = Collections.frequency(list, 6);
        System.out.println("里面有6的个数:"+count);*/

        /*List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(0);

        System.out.println("原序列:");
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println();

        *//*根据步长进行循环*//*
        Collections.rotate(list, -1);
        System.out.println("循环后:");
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }*/

        TreeNode left = new TreeNode(6, new TreeNode(4,
                new TreeNode(3, null, null),
                new TreeNode(5, null, null)),
                new TreeNode(8, null, null));
        TreeNode right = new TreeNode(14, new TreeNode(12, null, null),
                new TreeNode(16, null, null));
        Tree tree = new Tree(10, left, right);

        /*tree.tree2List(tree, null, null);
        TreeNode sortedList = tree.head;*/
        /*int count = 0;
        while (sortedList.rightSubTree != null && count++ < 100) {
            System.out.print(sortedList.value + " ");
            sortedList = sortedList.rightSubTree;
        }*/

        /*tree.findMax();
        System.out.print(tree.value + " ");
        Tree.findMax(tree);
        System.out.print(tree.value + " ");
        System.out.print(tree.rightSubTree.value + " ");*/

        /*Stack stack = new Stack(5);
        try {
            stack.push(3);
            stack.push(2);
            stack.push(100);
            stack.push(-1);
            stack.push(49);

            System.out.println(stack.min());
            System.out.println(stack.pop());

            System.out.println(stack.min());
            System.out.println(stack.pop());

            System.out.println(stack.min());
            System.out.println(stack.pop());

            System.out.println(stack.min());
            System.out.println(stack.pop());

            System.out.println(stack.min());
            System.out.println(stack.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
}
