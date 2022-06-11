package com.example.service;

import com.example.dao.PersonDAO;
import com.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> getAllPeople() {
        return personDAO.getAllPeople();
    }

    @Override
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    @Override
    public void deletePerson(int id) {
        personDAO.deletePerson(id);
    }

    @Override
    public void updatePerson(int id, Person person) {
        personDAO.updatePerson(id, person);
    }

    @Override
    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }
}
