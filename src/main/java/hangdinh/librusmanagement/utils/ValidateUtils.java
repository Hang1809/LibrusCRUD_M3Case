package hangdinh.librusmanagement.utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String NUMBER_REGEX = "\\d+";
    public static final String DATE_REGEX = "^[0-9]{4}-([0-9]|0[0-9]|1[0-2])-([0-9]|[0-2][0-9]|3[0-1])$";

    public static boolean isNumberValid(String number) {
        return Pattern.compile(NUMBER_REGEX).matcher(number).matches();
    }
    public static boolean isDateValid(String dateStr) {
        return Pattern.compile(DATE_REGEX).matcher(dateStr).matches();
    }
}
