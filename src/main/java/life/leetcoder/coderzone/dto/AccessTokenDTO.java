package life.leetcoder.coderzone.dto;

/**
 * @author laynewei
 * @date 9/18/20 10:37 PM
 * @e-mail lengning_wei@berkeley.edu
 * @description Store accesstokenDTO from github
 */
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redict_url;
    private String state;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedict_url() {
        return redict_url;
    }

    public void setRedict_url(String redict_url) {
        this.redict_url = redict_url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
