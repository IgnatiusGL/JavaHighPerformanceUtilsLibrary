package test.net;

import org.junit.jupiter.api.Test;
import top.ignatiusgl.net.WebUtils;

/**
 * @Description: Test the WebUtils
 * @author: IgnatiusGL
 * @date: 2022-06-11 10:38
 */
public class WebUtilsTest {
    @Test
    public void baseTest() {
        String webUrl = "https://www.baidu.com";
        String source = WebUtils.getSource(webUrl);
        System.out.println(source);
    }
}
