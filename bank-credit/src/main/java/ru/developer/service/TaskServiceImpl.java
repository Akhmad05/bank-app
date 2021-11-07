package ru.developer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.developer.dao.TaskDAO;
import ru.developer.model.Person;
import ru.developer.model.Task;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private PersonService personService;

    @Override
    public Person delete(int id) {
        Task task = taskDAO.getTask(id);
        return taskDAO.delete(task);
    }

    @Override
    public Task getTask(int id) {

        return taskDAO.getTask(id);
    }

    @Override
    public void update(String name, int id) {
        Task taskBeforeUpdate = taskDAO.getTask(id);
        taskBeforeUpdate.setName(name);
        taskDAO.update(taskBeforeUpdate);
    }

    @Override
    public void save(String name, int idPerson) {
        Person person = personService.getPerson(idPerson);
        Task task = new Task();
        task.setName(name);
        task.setPerson(person);

        taskDAO.save(task);
    }
}
