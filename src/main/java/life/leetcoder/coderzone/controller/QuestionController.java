package life.leetcoder.coderzone.controller;

import life.leetcoder.coderzone.dto.QuestionDTO;
import life.leetcoder.coderzone.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author laynewei
 * @time 9/24/20 12:50 PM
 * @e-mail lengning_wei@berkeley.edu
 */
@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id") Long id,
                           Model model){

        QuestionDTO questionDTO = questionService.getById(id);
        // increment view count
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
