package ru.developer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.developer.model.Person;
import ru.developer.model.Task;
import ru.developer.service.PersonServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/main")
public class PersonController {

    @Autowired
    private PersonServiceImpl personServiceImpl;

    @GetMapping
    public ModelAndView showAll() {
        ModelAndView mav = new ModelAndView("main/mainPage");
        List<Person> allPerson = personServiceImpl.getAll();
        mav.addObject("results", allPerson);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("person/edit");
        mav.addObject("person", personServiceImpl.getPerson(id));
        return mav;
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable int id, @RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname") String lastName) {
        Person tempPerson = new Person();
        tempPerson.setFirstname(firstName);
        tempPerson.setLastname(lastName);

        personServiceImpl.update(id, tempPerson);
        return "redirect:/main";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        personServiceImpl.delete(id);
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

        personServiceImpl.save(person);
        return "redirect:/main";
    }


    @GetMapping(value = "/gettasksperson")
    public @ResponseBody
    String getTasksAjax(@RequestParam(value = "id") int id) {
        String results = "";

        Person person = personServiceImpl.getPerson(id);

        if (person.getTasksList().isEmpty()) {
            results = "There are no tasks";
        } else {
            for (Task task : person.getTasksList()) {
                results = results + "<div>* " + task.getName() + "</div>";
            }
        }
        return "{\"idElement\":\"#tasks" + person.getId() + "\",\"text\":\"" + results + "\" }";
    }

}
