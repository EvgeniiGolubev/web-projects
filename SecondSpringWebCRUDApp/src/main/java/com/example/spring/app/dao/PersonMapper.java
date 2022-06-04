package com.example.spring.app.dao;

import com.example.spring.app.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// использовать этот класс для маппинга значений из базы либо класс BeanPropertyRowMapper (автоматически подставляет значения)
public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));

        return person;
    }
}
