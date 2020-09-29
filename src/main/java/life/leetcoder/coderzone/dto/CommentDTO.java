package life.leetcoder.coderzone.dto;

import lombok.Data;

/**
 * @author laynewei
 * @time 9/28/20 12:21 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Data
public class CommentDTO {
    private long parentId;
    private Integer type;
    private String content;
}
