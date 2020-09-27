package life.leetcoder.coderzone.advice;

import life.leetcoder.coderzone.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author laynewei
 * @time 9/25/20 11:32 AM
 * @e-mail lengning_wei@berkeley.edu
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model) {
        if(e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        } else {
            model.addAttribute("message","Service not working...try again later?");
        }
        return new ModelAndView("error");
    }

}
