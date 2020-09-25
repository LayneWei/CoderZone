package life.leetcoder.coderzone.model;

import lombok.Data;

/**
 * @author laynewei
 * @time 9/19/20 10:44 AM
 * @e-mail lengning_wei@berkeley.edu
 * @description store user information in database
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private long gmtCreate;
    private long gmtModified;
    private String avatarUrl;
    private String c;

}
