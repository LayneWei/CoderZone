package life.leetcoder.coderzone.exception;

/**
 * @author laynewei
 * @time 9/25/20 12:14 PM
 * @e-mail lengning_wei@berkeley.edu
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND("This question doesn't exist, try another one");

    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

}
