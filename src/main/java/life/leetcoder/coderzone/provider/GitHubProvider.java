package life.leetcoder.coderzone.provider;

import com.alibaba.fastjson.JSON;
import life.leetcoder.coderzone.dto.AccessTokenDTO;
import life.leetcoder.coderzone.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author laynewei
 * @date 9/18/20 10:41 PM
 * @e-mail lengning_wei@berkeley.edu
 */
@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        /* @source https://square.github.io/okhttp/
        *  use okhttp to get a url */
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            /* get token information after response */
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String[] split = string.split("&");
                String token = string.split("&")[0].split("=")[1];
                return token;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }

    public GitHubUser getUser(String access_token){
        /* @source https://square.github.io/okhttp/
        * use okhttp to post to a server */
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user"+"?access_token="+access_token)
                .build();
        /* get github user information and use fastjson to read and store in GithubUser class */
        try {
            Response response = client.newCall(request).execute();
            String string =response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
            return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }


}
