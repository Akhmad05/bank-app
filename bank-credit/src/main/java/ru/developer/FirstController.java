package ru.developer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

    @GetMapping(value = "/")
    public ModelAndView defaultView(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping(value = "/main")
    public ModelAndView mainView(){
        ModelAndView mav = new ModelAndView("mainPage");
        return mav;
    }
}
