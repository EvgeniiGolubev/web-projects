package com.example.creating.restful.service.service;

import com.example.creating.restful.service.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сейчас в роли хранилища клиентов будет выступать Map<Integer, Client>.
 * Ключом карты будет id клиента, а значением — сам клиент.
 * Сделано это для того, чтобы не перегружать пример спецификой работы с БД.
 * Однако в будущем мы сможем написать другую реализацию интерфейса,
 * в которой можно будет подключить реальную базу данных.
 *
 * Аннотация @Service говорит спрингу, что данный класс является сервисом.
 * Это специальный тип классов, в котором реализуется некоторая бизнес логика
 * приложения. Впоследствии, благодаря этой аннотации Spring будет
 * предоставлять нам экземпляр данного класса в местах, где это,
 * нужно с помощью Dependency Injection.
 */
//@Service
public class ClientServiceImpl implements ClientService {

    /**
     * temporary customer storage
     */
    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();

    /**
     * variable to generate ID
     */
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    /**
     * @param client - клиент для создания
     */
    @Override
    public void create(Client client) {
        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    /**
     * @return map with all clients
     */
    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    /**
     * @param id - ID клиента
     * @return client by id
     */
    @Override
    public Client read(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    /**
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return boolean task success
     */
    @Override
    public boolean update(Client client, int id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }

        return false;
    }

    /**
     * @param id - id клиента, которого нужно удалить
     * @return boolean task success
     */
    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }
}
