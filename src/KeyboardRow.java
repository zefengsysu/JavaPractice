import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wangzf5 on 2017/2/28.
 */
public class KeyboardRow {
    public static String[] findWords(String[] words) {
        List<String> resList = new ArrayList<>();

        String keyboardRow1 = "QWERTYUIOPqwertyuiop";
        String keyboardRow2 = "ASDFGHJKLasdfghjkl";
        String keyboardRow3 = "ZXCVBNMzxcvbnm";

        String theKeyboardRow = null;
        for (String word : words) {
            if (keyboardRow1.contains(Character.toString(word.charAt(0)))) {
                theKeyboardRow = keyboardRow1;
            } else if (keyboardRow2.contains(Character.toString(word.charAt(0)))) {
                theKeyboardRow = keyboardRow2;
            } else {
                theKeyboardRow = keyboardRow3;
            }

            if (isInTheRow(word, theKeyboardRow)) {
                resList.add(word);
            }
        }

        String[] res = new String[resList.size()];
        //return resList.toArray(res);
        return resList.toArray(new String[]{});
    }

    private static boolean isInTheRow(String word, String theKeyboardRow) {
        for (int i = 0; i < word.length(); i++) {
            if (!theKeyboardRow.contains(Character.toString(word.charAt(i)))) {
                return false;
            }
        }

        return true;
    }
}
