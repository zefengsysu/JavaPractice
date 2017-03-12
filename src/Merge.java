/**
 * Created by Wangzf5 on 2017/3/9.
 */
public class Merge {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode list1,ListNode list2) {
        ListNode res = null, current = null;

        while (list1 != null && list2 != null) {
            while (list1 != null && list2 != null && list1.val <= list2.val) {
                if (res == null) {
                    res = list1;
                    current = res;
                } else {
                    current.next = list1;
                    current = current.next;
                }

                list1 = list1.next;
            }

            while (list1 != null && list2 != null && list1.val > list2.val) {
                if (res == null) {
                    res = list2;
                    current = res;
                } else {
                    current.next = list2;
                    current = current.next;
                }

                list2 = list2.next;
            }
        }

        if (res == null) {
            if (list1 != null) {
                return list1;
            }
            if (list2 != null) {
                return list2;
            }
        } else if (list1 != null) {
            res.next = list1;
        } else if (list2 != null) {
            res.next = list2;
        }

        return res;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode res = merge.merge(list1, list2);
    }
}
