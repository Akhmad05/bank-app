package ru.developer.utils;

import org.springframework.stereotype.Component;
import ru.developer.model.Person;
import ru.developer.model.Task;

@Component
public class BuildStringForAjaxImpl implements BuildStringForAjax {
    @Override
    public String build(Person person) {
        String results = "";

        if (person.getTasksList().isEmpty()) {
            results = "There are no tasks";
        } else {
            for (Task task : person.getTasksList()) {
                results = results + "<div><i>" + task.getName() + "</i> <span class='delete' onclick='doAjaxPostDelete(" + task.getId() + ")'>delete</span> <a href='./task/" + task.getId() + "/edit'>update</a></div>";
            }
        }

        return results;
    }
}
