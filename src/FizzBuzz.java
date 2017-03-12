import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wangzf5 on 2017/2/28.
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        int i = 0;
        List<String> res = new ArrayList<>();

        while (i++ < n) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                sb.append(i + "");
            }
            res.add(sb.toString());
        }

        return res;
    }
}
