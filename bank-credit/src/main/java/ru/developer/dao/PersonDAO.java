package ru.developer.dao;

import ru.developer.model.Person;

import java.util.List;

public interface PersonDAO {
//    void save(Person person);

    List<Person> getAll();

    List<Person> getPerson(int id);
}
