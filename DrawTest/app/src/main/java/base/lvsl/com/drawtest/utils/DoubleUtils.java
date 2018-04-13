package base.lvsl.com.drawtest.utils;

import java.text.DecimalFormat;

/**
 * Created by JueYes on 2018/3/22.
 */

public class DoubleUtils {

    public static String changeDoubleToString(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("######0.00");
        return decimalFormat.format(number);
    }
}
