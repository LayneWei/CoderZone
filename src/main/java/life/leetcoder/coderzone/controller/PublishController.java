package life.leetcoder.coderzone.controller;

import life.leetcoder.coderzone.mapper.QuestionMapper;
import life.leetcoder.coderzone.mapper.UserMapper;
import life.leetcoder.coderzone.model.Question;
import life.leetcoder.coderzone.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author laynewei
 * @time 9/20/20 2:29 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping(value="/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            Model model,
            HttpServletRequest request){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if (title == null || title == "") {
            model.addAttribute("error","title cannnot be empty");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error","description cannnot be empty");
            return "publsih";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error","tag cannnot be empty");
            return "publish";
        }

        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        if (user == null) {
            model.addAttribute("error","Please log in your account");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);

        return "redirect:/";
    }
}
