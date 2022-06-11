package com.example.dao;

import com.example.models.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getAllPeople();
    void addPerson(Person person);
    void deletePerson(int id);
    void updatePerson(int id, Person person);
    Person getPersonById(int id);
}
