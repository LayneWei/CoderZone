package life.leetcoder.coderzone.model;

import lombok.Data;

/**
 * @author laynewei
 * @time 9/20/20 7:34 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Data
public class Question {
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
}
