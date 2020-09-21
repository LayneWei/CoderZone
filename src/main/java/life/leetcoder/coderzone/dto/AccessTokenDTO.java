package life.leetcoder.coderzone.dto;

import lombok.Data;

/**
 * @author laynewei
 * @date 9/18/20 10:37 PM
 * @e-mail lengning_wei@berkeley.edu
 * @description Store accesstokenDTO from github
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redict_url;
    private String state;

}
