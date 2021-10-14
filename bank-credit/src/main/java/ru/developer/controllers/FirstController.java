package ru.developer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.developer.dao.PersonDAO;

@Controller
public class FirstController {

    PersonDAO personDAO;

    @Autowired
    public FirstController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping(value = "/")
    public ModelAndView defaultView(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping(value = "/main")
    public ModelAndView mainView(){
        ModelAndView mav = new ModelAndView("mainPage");
        mav.addObject("result",  personDAO.showInfoUsers());
        return mav;
    }

}
