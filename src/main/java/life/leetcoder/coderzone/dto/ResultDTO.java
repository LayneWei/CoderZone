package life.leetcoder.coderzone.dto;

import life.leetcoder.coderzone.exception.CustomizeErrorCode;
import life.leetcoder.coderzone.exception.CustomizeException;
import lombok.Data;

/**
 * @author laynewei
 * @time 9/28/20 12:42 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Data
public class ResultDTO {
    private int code;
    private String message;

    public static ResultDTO errorOf(Integer code, String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.code = code;
        resultDTO.message = message;
        return resultDTO;

    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(),e.getMessage());
    }

    public static ResultDTO okOf(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.code = 200;
        resultDTO.message = "successful";
        return resultDTO;

    }
}
