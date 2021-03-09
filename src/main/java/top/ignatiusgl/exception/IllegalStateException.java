package top.ignatiusgl.exception;

/**
 * @Description: The Class status is not illegal. Such as the method multiple calls.
 * @author: IgnatiusGL
 * @date: 2021-03-04 14:52
 */
public class IllegalStateException extends RuntimeException{
    public IllegalStateException(String msg){
        super(msg);
    }
}
