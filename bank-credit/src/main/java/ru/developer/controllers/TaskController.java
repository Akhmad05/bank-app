package ru.developer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.developer.model.Person;
import ru.developer.service.PersonService;
import ru.developer.service.TaskService;
import ru.developer.utils.BuildStringForAjax;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private PersonService personService;

    @Autowired
    private BuildStringForAjax buildStringForAjax;

    @DeleteMapping("/{id}")
    public @ResponseBody
    String delete(@PathVariable int id) {
        Person person = taskService.delete(id);

        String results = buildStringForAjax.build(person);

        return "{\"idElement\":\"#tasks" + person.getId() + "\",\"text\":\"" + results + "\" }";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("task/edit");
        mav.addObject("task", taskService.getTask(id));

        return mav;
    }

    @PatchMapping("/{id}")
    public @ResponseBody
    String update(@PathVariable int id, @RequestParam(name = "name") String name) {
        taskService.update(name, id);
        return "message";
    }

    @GetMapping("{id}/new")
    public ModelAndView newTask(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("task/new");
        mav.addObject("person", personService.getPerson(id));

        return mav;
    }

    @PostMapping
    public @ResponseBody
    String create(@RequestParam(name = "name") String name, @RequestParam(name = "id") int idPerson) {
        taskService.save(name, idPerson);
        
        return "message";
    }
}
