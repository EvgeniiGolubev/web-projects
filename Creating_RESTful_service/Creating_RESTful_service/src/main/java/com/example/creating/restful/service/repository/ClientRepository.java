package com.example.creating.restful.service.repository;

import com.example.creating.restful.service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
