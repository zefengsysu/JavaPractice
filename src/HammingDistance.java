/**
 * Created by Wangzf5 on 2017/2/28.
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        /*int count = 0;

        String s = Integer.toBinaryString(x ^ y);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }*/

        int count = 0;

        int num = x ^ y;
        while (num >= 2) {
            count = num % 2 == 0 ? count : count + 1;
            num /= 2;
        }
        count = num == 1 ? count + 1 : count;

        return count;
    }
}
