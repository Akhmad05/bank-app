package ru.developer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.developer.Service.UsersService;


@Controller
public class MainController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/main")
    public ModelAndView showUserInfo() {
        ModelAndView mav = new ModelAndView("mainPage");
        mav.addObject("result", usersService.getUser());
        return mav;
    }

}
