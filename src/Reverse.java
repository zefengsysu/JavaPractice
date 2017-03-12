/**
 * Created by Wangzf5 on 2017/3/7.
 */
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A, B, K, commonFactor;

        A = sc.nextInt();
        B = sc.nextInt();
        K = sc.nextInt();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < B + 1; i++) {
            int temp = A + i * 2, count;
            commonFactor = gcd(temp, K);
            if (temp % commonFactor == 0) {
                count = temp / commonFactor;
                if (count < min) {
                    min = count;
                }
            }
        }

        if (min != Integer.MAX_VALUE) {
            System.out.print(min);
        } else {
            System.out.print(-1);
        }
    }

    private static int gcd(int a, int b) {
        int temp;

        while (a % b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }

        return b;
    }
}
