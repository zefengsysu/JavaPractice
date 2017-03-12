/**
 * Created by Wangzf5 on 2017/3/7.
 */
import java.util.Scanner;

public class FishSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rangeLow, rangeHigh, fishNum, count = 0;
        boolean safe;

        rangeLow = sc.nextInt();
        rangeHigh = sc.nextInt();
        fishNum = sc.nextInt();

        int[] fishs = new int[fishNum];
        for (int i = 0; i < fishNum; i++) {
            fishs[i] = sc.nextInt();
        }

        for (; rangeLow <= rangeHigh; rangeLow++) {
            safe = true;

            for (int i = 0; i < fishNum; i++) {
                int fish = fishs[i];
                if ((rangeLow >= 2 * fish && rangeLow <= 10 * fish) || (fish >= 2 * rangeLow && fish <= 10 * rangeLow)) {
                    safe = false;
                    break;
                }
            }

            if (safe) {
                count++;
            }
        }

        System.out.println(count);
    }
}
