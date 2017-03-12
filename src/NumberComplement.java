/**
 * Created by Wangzf5 on 2017/2/28.
 */
public class NumberComplement {
    public static int findComplement(int num) {
        /*int pow = 2;
        while (pow  <= num) {
            pow *= 2;
        }

        return pow - 1 - num;*/

        int weight = 1;
        int res = 0;

        while (num / 2 > 0) {
            res += num % 2 == 0 ? weight : 0;
            num /= 2;
            weight *= 2;
        }
        res += num == 0 ? weight : 0;

        return res;
    }
}
