package ru.developer.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.developer.model.Person;

import java.util.List;

@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    SessionFactory sessionFactory;

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
        Person person = sessionFactory.getCurrentSession().get(Person.class, id);
        return person;
    }

    @Override
    public void update(int id, Person tempPerson) {
        Person personBeforeUpdate = getPerson(id);
        personBeforeUpdate.setFirstname(tempPerson.getFirstname());
        personBeforeUpdate.setLastname(tempPerson.getLastname());
        save(personBeforeUpdate);
    }

    @Override
    public void delete(int id) {
        Person person = getPerson(id);
        sessionFactory.getCurrentSession().delete(person);
    }

}
