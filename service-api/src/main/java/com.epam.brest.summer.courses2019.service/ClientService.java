package com.epam.brest.summer.courses2019.service;

import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.model.stub.ClientStub;

import java.util.List;

/**
 * Client Service Interface.
 */
public interface ClientService {

    /**
     * Get all clients with devices.
     *
     * @return clients list.
     */
    List<ClientStub> findAllClientsWithDevices();

    /**
     * Find all clients stream.
     *
     * @return clients .
     */
    List<Client> findAll();

    /**
     * Find Client By Id.
     *
     * @param id id
     * @return Client
     */
    Client findById(Integer id);

    /**
     * Update client.
     *
     * @param client client
     */
    void update(Client client);

    /**
     * Delete Client.
     *
     * @param id client id
     */
    void delete(int id);

    void add(Client... clients);

    Client add(Client client);

}

