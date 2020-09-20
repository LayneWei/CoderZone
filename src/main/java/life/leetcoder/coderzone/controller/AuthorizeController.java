package life.leetcoder.coderzone.controller;

import life.leetcoder.coderzone.dto.AccessTokenDTO;
import life.leetcoder.coderzone.dto.GitHubUser;
import life.leetcoder.coderzone.mapper.UserMapper;
import life.leetcoder.coderzone.model.User;
import life.leetcoder.coderzone.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author laynewei
 * @date 9/18/20 10:35 PM
 * @e-mail lengning_wei@berkeley.edu
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedict_url(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser githubUser = gitHubProvider.getUser(accessToken);
        if (githubUser != null) {
            User user = new User();
            user.setAccountId(String.valueOf(githubUser.getName()));
            user.setName(githubUser.getName());
            user.setToken(UUID.randomUUID().toString());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            request.getSession().setAttribute("user", githubUser);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
}
