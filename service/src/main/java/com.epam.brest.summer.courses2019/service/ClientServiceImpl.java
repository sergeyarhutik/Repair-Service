package com.epam.brest.summer.courses2019.service;

import com.epam.brest.summer.courses2019.dao.ClientDao;
import com.epam.brest.summer.courses2019.dao.ClientStubDao;
import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.model.stub.ClientStub;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientStubDao clientStubDao;

    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao, ClientStubDao clientStubDao) {
        this.clientDao = clientDao;
        this.clientStubDao = clientStubDao;
    }

    @Override
    public List<ClientStub> findAllClientsWithDevices() {
        return clientStubDao.quantityOfClientDevices();
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findById(Integer id) {
        return clientDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to get client from DB"));
    }

    @Override
    public void update(Client client) {
    clientDao.update(client);
    }

    @Override
    public void delete(int id) {
    clientDao.delete(id);
    }

    @Override
    public void add(Client... clients) {
        for (Client client : clients) {
            clientDao.add(client);
        }
    }

    @Override
    public Client add(Client client) {
        return clientDao.add(client);
    }
}
