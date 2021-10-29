package ru.developer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.developer.service.PersonServiceImpl;
import ru.developer.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    String results;

    @Autowired
    private PersonServiceImpl personServiceImpl;

    @GetMapping(value = "/main")
    public ModelAndView showUserInfo() {
        ModelAndView mav = new ModelAndView("mainPage");
        List<Person> allPerson = personServiceImpl.getAll();
        mav.addObject("results", allPerson);
        return mav;
    }

    @GetMapping(value = "/gettasksperson")
    public @ResponseBody
    String getTasksAjax(@RequestParam(value = "id") int id) {
        // получить сразу объект Person по url параметру id не получилось, возможно, это работает только в буте, надо будет проверить.
        results = "";

        Optional<Person> personOptional = personServiceImpl.getPerson(id).stream().filter(pers -> pers.getId() == id).findAny();
        Person person = personOptional.get();

        if (person.getTasksList().size() == 0)
            results = "There are no tasks";
        person.getTasksList().stream().forEach(t -> results = results + "<div>* " + t.getName() + "</div>");

        return "{\"idElement\":\"#tasks" + person.getId() + "\",\"text\":\"" + results + "\" }";
    }

}
