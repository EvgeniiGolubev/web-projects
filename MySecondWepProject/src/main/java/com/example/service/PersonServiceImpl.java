package com.example.service;

import com.example.dao.PersonDAO;
import com.example.entities.Person;
import javax.transaction.Transactional;
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
    @Transactional
    public List<Person> getAllPeople() {
        return personDAO.getAllPeople();
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        personDAO.deletePerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }
}
