package life.leetcoder.coderzone.controller;

import life.leetcoder.coderzone.dto.AccessTokenDTO;
import life.leetcoder.coderzone.dto.GitHubUser;
import life.leetcoder.coderzone.model.User;
import life.leetcoder.coderzone.provider.GitHubProvider;
import life.leetcoder.coderzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author laynewei
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
    private UserService userService;



    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        /* store accesstokenDTO info from github */
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedict_url(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        /* use accesstokenDTO to get User */
        GitHubUser gitHubUser = gitHubProvider.getUser(accessToken);
        if (gitHubUser != null) {
            /* store user information to database*/
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setAccountId(String.valueOf(gitHubUser.getName()));
            user.setName(gitHubUser.getName());
            user.setToken(token);
            user.setAvatarUrl(gitHubUser.getAvatarUrl());
            userService.createOrUpdate(user);
            /* add cookie for maintaining log-in state */
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
