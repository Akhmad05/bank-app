package ru.developer.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.developer.model.Person;
import ru.developer.model.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Person delete(Task task) {
        Person person = task.getPerson();
        person.removeTask(task);

        return person;
    }

    @Override
    public Task getTask(int id) {
        return sessionFactory.getCurrentSession().get(Task.class, id);
    }

    @Override
    public void update(Task taskBeforeUpdate) {
        save(taskBeforeUpdate);
    }

    @Override
    public void save(Task task) {
        sessionFactory.getCurrentSession().save(task);
    }


}


