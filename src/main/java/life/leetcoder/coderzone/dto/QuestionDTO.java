package life.leetcoder.coderzone.dto;

import life.leetcoder.coderzone.model.User;
import lombok.Data;

/**
 * @author laynewei
 * @time 9/20/20 7:54 PM
 * @e-mail lengning_wei@berkeley.edu
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private long gmtCreate;
    private long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer likeCount;
    private Integer viewCount;
    private User user;
}
