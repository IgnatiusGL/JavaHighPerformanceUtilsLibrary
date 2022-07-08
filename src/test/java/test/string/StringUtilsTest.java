package test.string;

import org.junit.jupiter.api.Test;
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
                "sdasd-*+wqd",
        };
        for (int i = 0; i < testString.length; i++) {
            testString[i] = StringUtils.replaceAllToOne(testString[i], new String[]{"*","+","-"}, "");
        }
        assert testString[0].equals("testasd");
        assert testString[1].equals("asd1212312asd");
        assert testString[2].equals("asdasd");
        assert testString[3].equals("asd1212312asd");
        assert testString[4].equals("sdasdwqd");
        System.out.println("StringUtils-replaceAllToOne: pass");

        System.out.println("----------------------------------------------------");

        testString = new String[]{
                "test-asd",
                "big-data",
                "background-icon",
                "button-login",
                "submit-record",
        };
        for (int i = 0; i < testString.length; i++) {
            testString[i] = StringUtils.toHumpString(testString[i], "-", true);
        }
        assert testString[0].equals("TestAsd");
        assert testString[1].equals("BigData");
        assert testString[2].equals("BackgroundIcon");
        assert testString[3].equals("ButtonLogin");
        assert testString[4].equals("SubmitRecord");
        System.out.println("StringUtils-toHumpString1: pass");

        testString = new String[]{
                "test_asd",
                "big_data",
                "background_icon",
                "button_login",
                "submit_record",
                "submit_record_1",
                "submit_record1",
        };
        for (int i = 0; i < testString.length; i++) {
            testString[i] = StringUtils.toHumpString(testString[i], "_", false);
        }
        assert testString[0].equals("testAsd");
        assert testString[1].equals("bigData");
        assert testString[2].equals("backgroundIcon");
        assert testString[3].equals("buttonLogin");
        assert testString[4].equals("submitRecord");
        assert testString[5].equals("submitRecord1");
        assert testString[6].equals("submitRecord1");
        System.out.println("StringUtils-toHumpString2: pass");

        System.out.println("----------------------------------------------------");

        testString = new String[]{
                "testAsd",
                "bigData",
                "BackgroundIcon",
                "buttonLogin",
                "SubmitRecord",
                "submitRecord1",
                "SubmitRecord1",
        };
        for (int i = 0; i < testString.length; i++) {
            testString[i] = StringUtils.toSeparatorString(testString[i], "_");
        }
        assert testString[0].equals("test_asd");
        assert testString[1].equals("big_data");
        assert testString[2].equals("background_icon");
        assert testString[3].equals("button_login");
        assert testString[4].equals("submit_record");
        assert testString[5].equals("submit_record_1");
        assert testString[6].equals("submit_record_1");
        System.out.println("StringUtils-toSeparatorString: pass");
    }
}
