package top.ignatiusgl.exception;

/**
 * @Description: The method parameter is illegal.
 * @author: IgnatiusGL
 * @date: 2022-06-11 11:15
 */
public class IllegalParameterException extends RuntimeException {
    public IllegalParameterException(String msg) {
        super(msg);
    }
}
