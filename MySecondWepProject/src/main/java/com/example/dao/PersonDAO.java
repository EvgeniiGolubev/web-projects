package com.example.dao;

import com.example.entities.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getAllPeople();
    void addPerson(Person person);
    void deletePerson(Person person);
    void updatePerson(Person person);
    Person getPersonById(int id);
}
