package com.epam.brest.summer.courses2019.service;

import com.epam.brest.summer.courses2019.model.Client;
import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client findById(Integer id);

    void update(Client client);

    void delete(int id);

    void add(Client... clients);

    Client add(Client client);

}

