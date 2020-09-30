package life.leetcoder.coderzone.dto;

import life.leetcoder.coderzone.model.User;
import lombok.Data;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
@Data
public class CommentDTO {

    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
