package life.leetcoder.coderzone.dto;

import lombok.Data;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redict_url;
    private String state;

}
