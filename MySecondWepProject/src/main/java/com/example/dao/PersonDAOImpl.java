package com.example.dao;

import com.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO посмотреть как правильно создавать таблицы (сколько знаков знаков нужно для имайла)
@Repository
public class PersonDAOImpl implements PersonDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> getAllPeople() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Person").list();
    }

    @Override
    public void addPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Override
    public void deletePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(person);
    }

    @Override
    public void updatePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.update(person);
    }

    @Override
    public Person getPersonById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }
}
