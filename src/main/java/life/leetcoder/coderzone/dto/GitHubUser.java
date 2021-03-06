package life.leetcoder.coderzone.dto;

import lombok.Data;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */

@Data
public class GitHubUser {
    private long id;
    private String name;
    private String bio;
    private String avatarUrl;
}
