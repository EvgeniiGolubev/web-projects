package com.example.service;

import com.example.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public List<Person> getAllPeople() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Миша", 12, "misha@mail.com", "79998887766"));
        list.add(new Person(2, "Маша", 9, "masha@mail.com", "+79998887766"));
        list.add(new Person(2, "Леша", 7, "lesha@mail.com", "+7-999-888-77-66"));
        list.add(new Person(2, "Паша", 11, "pasha@mail.com", "89998887766"));
        return list;
    }

    @Override
    public void addPerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public void editPerson(Person person) {

    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }
}
