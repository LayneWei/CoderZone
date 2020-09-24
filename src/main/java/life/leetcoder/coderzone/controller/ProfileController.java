package life.leetcoder.coderzone.controller;

import life.leetcoder.coderzone.dto.PaginationDTO;
import life.leetcoder.coderzone.mapper.UserMapper;
import life.leetcoder.coderzone.model.User;
import life.leetcoder.coderzone.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author laynewei
 * @time 9/21/20 10:09 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Controller
public class ProfileController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name="action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size) {
        User user = null;
        Cookie[] cookies = request.getCookies();
        /* if cookie has user token, then go to user main page */
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        if (user == null) {
            return "redirect:/";
        }


        if ("questions".equals(action)) {
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","My Questions");
        }
        if("replies".equals(action)) {
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","Latest Replies");
        }

        PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
        model.addAttribute("pagination", paginationDTO);

        return "profile";
    }
}
