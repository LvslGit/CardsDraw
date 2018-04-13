package base.lvsl.com.drawtest.utils;

/**
 * Created by JueYes on 2018/3/22.
 */

public class StringUtils {

    // 字符串加密
    public static String changeStringEncryption(String string) {

        if (string == null || string.isEmpty() || string.length() == 0 || string.length() == 1)
            return "*";

        if (string.length() == 2) return "**";

        String newString = "";
        for (int i = 0; i < string.length() - 2; i++) {
            newString = newString + "*";
        }

        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.replace(1, string.length() - 1, newString);

        return stringBuilder.toString();


    }
}
