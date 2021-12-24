package test.file;

import org.junit.jupiter.api.Test;
import top.ignatiusgl.file.FileTools;

import java.io.File;

/**
 * @Description: Test the FileTools
 * @author: IgnatiusGL
 * @date: 2021-12-24 16:13
 */
public class FileToolsTest {
    @Test
    public void listFileTest() {
        FileTools.listFile(new File(getClass().getResource("/").getFile()), e -> System.out.println(e.getName()));
    }
}
