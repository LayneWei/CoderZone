package life.leetcoder.coderzone.exception;

/**
 * @author laynewei
 * @time 9/25/20 12:01 PM
 * @e-mail lengning_wei@berkeley.edu
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public Integer getCode() {
        return code;
    }

    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();

    }

    @Override
    public String getMessage() {
        return message;
    }
}
