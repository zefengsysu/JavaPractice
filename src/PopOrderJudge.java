import java.util.Stack;
/**
 * Created by Wangzf5 on 2017/3/10.
 */
public class PopOrderJudge {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null) {
            if (popA == null) {
                return true;
            }
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> A = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            A.push(pushA[i]);
        }

        int top = A.pop();
        int index = 0;
        boolean findTop = false;
        for (; index < popA.length; index++) {
            if (popA[index] == top) {
                findTop = true;
                break;
            }
        }
        index++;

        if (!findTop) {
            return false;
        }

        int current;
        for (; index < popA.length; index++) {
            current = popA[index];

            while (!A.isEmpty() && current != A.pop());
            if (index < popA.length - 1 && A.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PopOrderJudge p = new PopOrderJudge();
        p.IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[] {4, 5, 3, 2, 1});
    }
}
