package test.net;

import org.junit.jupiter.api.Test;
import top.ignatiusgl.net.HTML;
import top.ignatiusgl.net.WebUtils;

import java.util.List;

/**
 * @Description: Test the HTML
 * @author: IgnatiusGL
 * @date: 2022-06-11 10:53
 */
public class HTMLTest {
    @Test
    public void baseTest() {
        String source = WebUtils.getSource("https://www.baidu.com");
        HTML html = new HTML(source);
        List<HTML> divs = html.div("#wrapper").tag("div");
        System.out.println(divs);
    }
}
