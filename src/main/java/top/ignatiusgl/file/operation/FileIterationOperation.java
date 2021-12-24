package top.ignatiusgl.file.operation;

import java.io.File;

@FunctionalInterface
public interface FileIterationOperation {
    /**
     * Do something in file iteration
     * @param file iteration file
     */
    void fileOperation(File file);
}
