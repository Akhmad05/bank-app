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

    @Override
    public Person delete(Task task) {
        return taskDAO.delete(task);
    }

    @Override
    public Task getTask(int id) {
        return taskDAO.getTask(id);
    }

    @Override
    public void update(Task taskBeforeUpdate) {
        taskDAO.update(taskBeforeUpdate);
    }

    @Override
    public void save(Task task) {
        taskDAO.save(task);
    }
}
