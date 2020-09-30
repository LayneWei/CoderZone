package life.leetcoder.coderzone.exception;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"This question doesn't exist, try another one"),
    TARGET_PARAM_NOT_FOUND(2002,"Please select a question/comment to reply"),
    NO_LOGIN(2003,"Please log in first"),
    SYSTEM_ERROR(2004,"Service not working...try again later?"),
    TYPE_PARAM_WRONG(2005,"Comment type error or not exists"),
    COMMENT_NOT_FOUND(2006,"The comment you're looking for doesn't exist"),
    COMMENT_IS_EMPTY(2007,"The comment cannot be empty")
    ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
