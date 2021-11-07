package ru.developer.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.developer.model.Person;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public List<Person> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    public Person getPerson(int id) {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Override
    public void update(Person person) {
        save(person);
    }

    @Override
    public void delete(Person person) {
        sessionFactory.getCurrentSession().delete(person);
    }

}
