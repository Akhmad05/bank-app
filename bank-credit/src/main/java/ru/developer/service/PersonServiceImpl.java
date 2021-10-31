package ru.developer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.developer.dao.PersonDAO;
import ru.developer.model.Person;

import java.util.List;

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


    @Override
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Override
    public void update(int id, Person tempPerson) {
        personDAO.update(id, tempPerson);
    }

    @Override
    public void delete(int id) {
        personDAO.delete(id);
    }

}
