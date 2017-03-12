import java.util.ArrayList;

/**
 * Created by Wangzf5 on 2017/3/9.
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> odds = new ArrayList<Integer>();
        ArrayList<Integer> evens = new ArrayList<Integer>();

        for (Integer i : array) {
            if (i % 2 != 0) {
                odds.add(i);
            } else {
                evens.add(i);
            }
        }

        int arrayIndex = 0;
        for (int i = 0; i < odds.size(); i++, arrayIndex++) {
            array[arrayIndex] = odds.get(i);
        }
        for (int i = 0; i < evens.size(); i++, arrayIndex++) {
            array[arrayIndex] = evens.get(i);
        }

        odds = null;
        evens = null;
    }
}
