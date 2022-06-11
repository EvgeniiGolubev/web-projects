package com.example.dao;

import com.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//TODO посмотреть как правильно создавать таблицы (сколько знаков знаков нужно для имайла)
//TODO перейти на Hibernet
@Component
public class PersonDAOImpl implements PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getAllPeople() {
        return jdbcTemplate.query("SELECT * FROM people", new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public void addPerson(Person person) {
        jdbcTemplate.update("INSERT INTO people (name, age, email, telephoneNumber) VALUES (?, ?, ?, ?)",
                person.getName(),
                person.getAge(),
                person.getEmail(),
                person.getTelephoneNumber());
    }

    @Override
    public void deletePerson(int id) {
        jdbcTemplate.update("DELETE FROM people WHERE id=?", id);
    }

    @Override
    public void updatePerson(int id, Person person) {
        jdbcTemplate.update("UPDATE people SET name=?, age=?, email=?, telephoneNumber=? WHERE id=?",
                person.getName(),
                person.getAge(),
                person.getEmail(),
                person.getTelephoneNumber(),
                id);
    }

    @Override
    public Person getPersonById(int id) {
        return jdbcTemplate.query("SELECT * FROM people WHERE id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }
}
