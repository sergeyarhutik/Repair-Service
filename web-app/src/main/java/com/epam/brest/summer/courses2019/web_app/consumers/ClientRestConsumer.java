package com.epam.brest.summer.courses2019.web_app.consumers;

import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.model.stub.ClientStub;
import com.epam.brest.summer.courses2019.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ClientRestConsumer implements ClientService {

    private String url;

    private RestTemplate restTemplate;

    public ClientRestConsumer(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ClientStub> findAllClientsWithDevices() {
        ResponseEntity responseEntity = restTemplate.getForEntity(url + "/with_devices", List.class);
        return (List<ClientStub>) responseEntity.getBody();
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Client findById(Integer id) {
        ResponseEntity<Client> responseEntity = restTemplate.getForEntity(url + "/" + id, Client.class);
        return responseEntity.getBody();
    }

    @Override
    public void update(Client client) {
        restTemplate.put(url, client);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(url + "/" + id);
    }

    @Override
    public void add(Client... clients) {
        for (Client client : clients) {
            restTemplate.postForEntity(url, client, Client.class);
        }
    }

    @Override
    public Client add(Client client) {
        ResponseEntity responseEntity = restTemplate.postForEntity(url, client, Client.class);
        Object result = responseEntity.getBody();
        return (Client) result;
    }
}
