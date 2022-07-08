package top.ignatiusgl.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @Description: Built-in tools for handling strings
 * @author: IgnatiusGL
 * @date: 2021-03-25 13:34
 */
public class StringUtils {
    /**
     * Replace the value according to the value passed in
     * <p>
     * Examples:
     * <blockquote><pre>
     *     replaceAllToOne("123pre213pres2456qwe", new String[]{"pre", "qwe"}, "test") returns "123test213tests2456test"
     * </pre></blockquote>
     *
     * @param value    value that passed in
     * @param oldChars string that you want to replace
     * @param newChar  string that final version
     * @return value that you've processed
     */
    public static String replaceAllToOne(String value, String[] oldChars, String newChar) {
        for (String oldChar : oldChars) {
            value = value.replace(oldChar, newChar);
        }
        return value;
    }

    /**
     * Converting strings with separator to humps
     * <p>
     * Examples:
     * <blockquote><pre>
     *     toHumpString("test-example", "-", true) returns "TestExample"
     *     toHumpString("test_example", "_", false) returns "testExample"
     * </pre></blockquote>
     *
     * @param value     string that have separator
     * @param separator word segmentation types
     * @param isUpper   if true convert to upper hump else convert to lower hump
     * @return converted string
     */
    public static String toHumpString(String value, String separator, boolean isUpper) {
        if (isUpper) {
            value = value.substring(0, 1).toUpperCase() + value.substring(1);
        }

        char[] chars = value.toCharArray();
        char[] resultChars = new char[value.replace(separator, "").length()];
        char[] separatorChars = separator.toCharArray();
        int index = 0, resultIndex = 0;
        for (char aChar : chars) {
            if (index == separatorChars.length) {
                resultChars[resultIndex++] = (char) (aChar - 32);
                index = 0;
            } else if (aChar == separatorChars[index]) {
                index++;
            } else {
                resultChars[resultIndex++] = aChar;
            }
        }

        return new String(resultChars);
    }

    /**
     * Converting strings with separator to upper humps
     * @refer toHumpString
     */
    public static String toUpperHump(String value, String separator) {
        return toHumpString(value, separator, true);
    }

    /**
     * Converting strings with separator to Lower humps
     * @refer toHumpString
     */
    public static String toLowerHump(String value, String separator) {
        return toHumpString(value, separator, false);
    }

    /**
     * Converting UpperHump or LowerHump to separator string
     * <p>
     * Examples:
     * <blockquote><pre>
     *     toSeparatorString("testExample", "-") returns "test-example"
     *     toSeparatorString("TestExample", "_") returns "test_example"
     * </pre></blockquote>
     *
     * @param value     upper/lower hump string
     * @param separator hyphen, underscore or other separator
     * @return converted string
     */
    public static String toSeparatorString(String value, String separator) {
        value = value.substring(0, 1).toLowerCase() + value.substring(1);

        char[] chars = value.toCharArray();
        List<Character> resultChars = new ArrayList<>();
        List<Character> separatorChars = new ArrayList<>();
        for (char c : separator.toCharArray()) {
            separatorChars.add(c);
        }
        for (char aChar : chars) {
            if (aChar >= 65 && aChar <= 90) {
                resultChars.addAll(separatorChars);
                resultChars.add((char) (aChar + 32));
            } else {
                resultChars.add(aChar);
            }
        }
        char[] result = new char[resultChars.size()];
        for (int i = 0; i < resultChars.size(); i++) {
            result[i] = resultChars.get(i);
        }
        return new String(result);
    }
}
