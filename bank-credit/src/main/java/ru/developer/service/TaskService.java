package ru.developer.service;

import ru.developer.model.Person;
import ru.developer.model.Task;

public interface TaskService {
    Person delete(int id);

    Task getTask(int id);

    void update(String name, int id);

    void save(String name, int id);
}
