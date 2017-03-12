/**
 * Created by Wangzf5 on 2017/2/27.
 */
public class LinkList {

    private Node head = null, current = null;

    public LinkList() {}

    public void add(int value) {
        Node node = new Node(value,null);
        if (head == null) {
            head = current = node;
        } else {
            current.next = node;
            current = node;
        }
    }

    public void reverseLinkedList() {
        if (head != null) {
            Node tmp = null, prev = null;

            current = head;
            prev = head.next;
            head.next = null;
            while (prev != null) {
                tmp = prev;
                prev = tmp.next;
                tmp.next = head;
                head = tmp;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node tmp = head;

        while (tmp != null) {
            stringBuilder.append(tmp.value);
            tmp = tmp.next;
        }

        return stringBuilder.toString();
    }
}
