package life.leetcoder.coderzone.dto;

import lombok.Data;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
@Data
public class CommentCreateDTO {
    private long parentId;
    private Integer type;
    private String content;
}
