package ru.developer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.developer.service.PersonServiceImpl;
import ru.developer.model.Person;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PersonServiceImpl personServiceImpl;

    @GetMapping(value = "/main")
    public ModelAndView showUserInfo() {
        ModelAndView mav = new ModelAndView("mainPage");
        List<Person> allPerson = personServiceImpl.getAll();
        mav.addObject("results", allPerson);
        return mav;
    }

}
