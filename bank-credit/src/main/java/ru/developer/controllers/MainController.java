package ru.developer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.developer.Service.UsersService;
import ru.developer.dao.PersonDAO;


@Controller
public class MainController {
    @Autowired
    private UsersService dmlReaderService;

    PersonDAO personDAO;

    @Autowired
    public MainController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping(value = "/main")
    public ModelAndView showUserInfo() {
        ModelAndView mav = new ModelAndView("mainPage");
        mav.addObject("result", dmlReaderService.getUser());
        return mav;
    }

}
