package com.epam.brest.summer.courses2019.rest_app;

import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.model.stub.ClientStub;
import com.epam.brest.summer.courses2019.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ClientRestController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/clients")
    public Collection<Client> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/clients/with_devices")
    public List<ClientStub> findAllStubs() {
        return service.findAllClientsWithDevices();
    }

    @GetMapping(value = "/clients/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Client findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PutMapping()
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void update(@RequestBody Client client) {
        service.update(client);
    }

    @DeleteMapping(value = "/clients/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @PostMapping()
    public ResponseEntity<Client> add(@RequestBody Client client) {
        Client result = service.add(client);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
