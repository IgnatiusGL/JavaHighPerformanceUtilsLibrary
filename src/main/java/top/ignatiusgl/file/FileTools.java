package top.ignatiusgl.file;

import top.ignatiusgl.file.operation.FileIterationOperation;

import java.io.File;
import java.util.Objects;

/**
 * @Description:
 * @author: IgnatiusGL
 * @date: 2021-03-25 12:45
 */
public class FileTools {
    /**
     * Iteration file and do something
     *
     * @param rootFile  root file
     * @param operation operation in iteration
     */
    public static void listFile(File rootFile, FileIterationOperation operation) {
        if (rootFile.isDirectory()) {
            File[] files = rootFile.listFiles();
            if (Objects.requireNonNull(files).length > 0) {
                for (File file : files) {
                    listFile(file, operation);
                }
            }
        } else {
            operation.fileOperation(rootFile);
        }
    }
}
