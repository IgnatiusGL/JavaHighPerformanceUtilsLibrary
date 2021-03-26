package top.ignatiusgl.string;

/**
 * @Description: Defines the character composition type of a String.
 * @author: IgnatiusGL
 * @date: 2021-03-26 13:20
 */
public enum StringType {
    /**
     * The String use - connect each word.
     */
    UNDERSCORE("_"),

    /**
     * The String use _ connect each word.
     */
    HYPHEN("-");


    String value;

    StringType(String value) {
        this.value = value;
    }
}
