package ru.developer.dao;

import ru.developer.model.Person;
import ru.developer.model.Task;

public interface TaskDAO {
    Person delete(Task task);

    Task getTask(int id);

    void update(Task taskBeforeUpdate);

    void save(Task task);
}
