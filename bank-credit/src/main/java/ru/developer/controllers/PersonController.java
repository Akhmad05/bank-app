package ru.developer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.developer.model.Person;
import ru.developer.service.PersonService;
import ru.developer.utils.BuildStringForAjax;

@Controller
@RequestMapping("/main")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private BuildStringForAjax buildStringForAjax;

    @GetMapping
    public ModelAndView showAll() {
        ModelAndView mav = new ModelAndView("main/mainPage");
        mav.addObject("results", personService.getAll());
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("person/edit");
        mav.addObject("person", personService.getPerson(id));
        return mav;
    }

    @Transactional // плохая идея указывать в контроллере, переговорить с Евгением
    @PatchMapping("/{id}")
    public String update(@PathVariable int id, @RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname") String lastName) {

        Person person = personService.getPerson(id);

        person.setFirstname(firstName);
        person.setLastname(lastName);

        personService.update(person);

        return "redirect:/main";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        personService.delete(personService.getPerson(id));
        return "redirect:/main";
    }

    @GetMapping("/new")
    public String newPerson() {
        return "person/new";
    }

    @PostMapping
    public String create(@RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname") String lastName) {
        Person person = new Person();
        person.setFirstname(firstName);
        person.setLastname(lastName);

        personService.save(person);
        return "redirect:/main";
    }


    @GetMapping(value = "/gettasksperson")
    public @ResponseBody
    String getTasksAjax(@RequestParam(value = "id") int id) {
        String results = "";

        Person person = personService.getPerson(id);

        if (person.getTasksList().isEmpty()) {
            results = "There are no tasks";
        } else {
            results = buildStringForAjax.build(person);
        }
        return "{\"idElement\":\"#tasks" + person.getId() + "\",\"text\":\"" + results + "\" }";
    }

}
