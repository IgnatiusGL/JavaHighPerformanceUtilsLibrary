package top.ignatiusgl.string;

/**
 * @Description: Built-in tools for handling strings
 * @author: IgnatiusGL
 * @date: 2021-03-25 13:34
 */
public class StringUtils {
    /**
     * Replace the value according to the value passed in
     *
     * @param value value that passed in
     * @return value that you've processed
     */
    public static String replaceAllToOne(String value, String[] oldChars, String newChar) {
        for (String oldChar : oldChars) {
            value = value.replace(oldChar, newChar);
        }
        return value;
    }

    public static String toUpperHump(String value, StringType type) {
        value = value.substring(0,1).toUpperCase() + value.substring(1);

        while (value.contains(type.value)) {
            int segmentIndex = value.indexOf(type.value);
            String segment = value.substring(segmentIndex, segmentIndex + type.value.length() + 1);
            String newSegment = segment.substring(type.value.length()).toUpperCase();
            value = value.replace(segment, newSegment);
        }

        return value;
    }
}
