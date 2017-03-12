/**
 * Created by Wangzf5 on 2017/3/9.
 */
public class NumberOf1 {
    public static int numberOf1(int n) {
        /*int count = 0;
        if (n > 0) {
            while (n != 1) {
                count += n % 2 == 0 ? 0 : 1;
                n /= 2;
            }
            count++;
        } else if (n < 0) {
            int count0 = 0;

            n = -n;
            count0 += n % 2 == 0 ? 1 : -1;
            while (n != 1) {
                count0 += n % 2 == 0 ? 0 : 1;
                n /= 2;
            }
            count0++;

            count = 32 - count0;
        }
        return count;*/
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print(numberOf1(-2147483648));
    }
}
