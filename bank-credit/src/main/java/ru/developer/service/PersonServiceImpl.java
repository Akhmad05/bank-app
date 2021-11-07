package ru.developer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.developer.dao.PersonDAO;
import ru.developer.model.Person;

import java.util.List;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }


    @Transactional
    @Override
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Override
    public void update(Person tempPerson) {
        Person person = personDAO.getPerson(tempPerson.getId());
        person.setFirstname(tempPerson.getFirstname());
        person.setLastname(tempPerson.getLastname());
        personDAO.update(person);
    }


    @Override
    public void delete(Person person) {
        personDAO.delete(person);
    }

}
