/**
 * Created by Wangzf5 on 2017/3/12.
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null) {
            return false;
        }

        return VerifySquenceOfBST(sequence, 0, sequence.length);
    }

    public boolean VerifySquenceOfBST(int [] sequence, int begin, int end) {
        int length = begin - end;

        if (length == 0) {
            return false;
        }
        if (length == 1 || length == 2 ||
                isMin2Max(sequence, begin, end) || isMax2Min(sequence, begin, end)) {
            return true;
        }

        int middle = sequence[end - 1], leftEnd = begin;
        for (; leftEnd < end - 1; leftEnd++) {
            if (sequence[leftEnd] > middle) {
                break;
            }
        }
        boolean verifyLeft = VerifySquenceOfBST(sequence, begin, leftEnd);

        if (leftEnd != end) {
            for (int i = leftEnd; i < end - 1; i++) {
                if (sequence[i] < middle) {
                    return false;
                }
            }
            boolean verifyRight = VerifySquenceOfBST(sequence, leftEnd, end - 1);

            return verifyLeft && verifyRight;
        }

        return verifyLeft;
    }

    public boolean isMin2Max(int [] sequence, int begin, int end) {
        for (int i = begin; i < end - 1; i++) {
            if (sequence[i] > sequence[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public boolean isMax2Min(int [] sequence, int begin, int end) {
        for (int i = begin; i < end - 1; i++) {
            if (sequence[i] < sequence[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        VerifySquenceOfBST v = new VerifySquenceOfBST();

        System.out.print(v.VerifySquenceOfBST(new int[]{1, 3, 2, 6, 7, 5, 4}));
    }
}
