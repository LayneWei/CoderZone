package life.leetcoder.coderzone.dto;

import lombok.Data;

/**
 * @author laynewei
 * @time 9/19/20 1:45 AM
 * @e-mail lengning_wei@berkeley.edu
 * @description store GitHubUser information from json
 */

@Data
public class GitHubUser {
    private long id;
    private String name;
    private String bio;
    private String avatarUrl;
}
