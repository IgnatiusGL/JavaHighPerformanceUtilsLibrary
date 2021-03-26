package test.string;

import org.junit.jupiter.api.Test;
import top.ignatiusgl.string.StringType;
import top.ignatiusgl.string.StringUtils;

import java.util.Arrays;

/**
 * @Description: Test the StringUtils
 * @author: IgnatiusGL
 * @date: 2021-03-25 18:21
 */
public class StringUtilsTest {
    @Test
    public void baseTest() {
        String[] testString = new String[]{
                "test-asd",
                "asd12*12312asd",
                "asd*asd",
                "asd12*1231-2asd",
                "sdasd-*+wqd"
        };
        for (int i = 0; i < testString.length; i++) {
            testString[i] = StringUtils.replaceAllToOne(testString[i], new String[]{"*","+","-"}, "");
        }
        System.out.println("StringUtils-replaceAllToOne:" + Arrays.asList(testString));

        System.out.println("----------------------------------------------------");

        testString = new String[]{
                "test-asd",
                "big-data",
                "background-icon",
                "button-login",
                "submit-record"
        };
        for (int i = 0; i < testString.length; i++) {
            testString[i] = StringUtils.toUpperHump(testString[i], StringType.HYPHEN);
        }
        System.out.println("StringUtils-replaceAllToOne1:" + Arrays.asList(testString));
        testString = new String[]{
                "test_asd",
                "big_data",
                "background_icon",
                "button_login",
                "submit_record"
        };
        for (int i = 0; i < testString.length; i++) {
            testString[i] = StringUtils.toUpperHump(testString[i], StringType.UNDERSCORE);
        }
        System.out.println("StringUtils-replaceAllToOne2:" + Arrays.asList(testString));
    }
}
