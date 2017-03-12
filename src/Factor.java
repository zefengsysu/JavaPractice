/**
 * Created by Wangzf5 on 2017/3/7.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        boolean success = true;
        int middle, countMiddle, sum;
        List<Integer> factors = new ArrayList<>();

        while (true) {
            middle = N / L;
            countMiddle = L % 2 == 0 ? L / 2 : (L + 1) / 2;
            sum = 0;
            factors.clear();

            for (int i = countMiddle - 1; i >= 1; i--) {
                int num = middle - i;

                if (num < 0) {
                    success = false;
                    break;
                }

                factors.add(num);
                sum += num;
            }
            factors.add(middle);
            sum += middle;
            for (int i = 1; i <= L - countMiddle; i++) {
                int num = middle + i;
                factors.add(num);
                sum += num;
            }

            if (L > 100) {
                success = false;
                break;
            }

            if (sum == N) {
                break;
            } else if ((N - sum) % L == 0) {
                int dis = (N - sum) / L;

                for (int i = 0; i < L; i++) {
                    int num = factors.get(i) + dis;
                    factors.add(i, num);
                }

                break;
            } else if ((sum - N) % L == 0) {
                int dis = (sum - N) / L;

                for (int i = 0; i < L; i++) {
                    int num = factors.get(i) - dis;
                    factors.add(i, num);
                }

                break;
            } else {
                L++;
            }
        }

        if (success) {
            int i = 0;
            for (; i < L - 1; i++) {
                System.out.print(factors.get(i) + " ");
            }
            System.out.print(factors.get(i));
        } else {
            System.out.print("No");
        }

    }
}
