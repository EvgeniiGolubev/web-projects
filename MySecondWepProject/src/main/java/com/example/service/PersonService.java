package com.example.service;

import com.example.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPeople();
    void addPerson(Person person);
    void deletePerson(Person person);
    void editPerson(Person person);
    Person getPersonById(int id);
}
