package com.epam.brest.summer.courses2019.web_app;

import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Device controller.
 */
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Goto client list page.
     *
     * @param model model
     * @return view name
     */
    @GetMapping(value = "/clients")
    public final String clients(Model model) {
        model.addAttribute("clients", clientService.findAllClientsWithDevices());
        return "clients";
    }

    /**
     * Goto edit client page.
     *
     * @return view name
     */
    @GetMapping(value = "/client/{id}")
    public final String gotoEditClientPage(@PathVariable Integer id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client";
    }

    /**
     * Update client into persistence storage.
     *
     * @return view name
     */
    @PostMapping(value = "/client/{id}")
    public String updateClient(Client client) {
            this.clientService.update(client);
            return "redirect:/clients";
    }

    /**
     * Goto add client page.
     *
     * @return view name
     */
    @GetMapping(value = "/client")
    public final String gotoAddClientPage(Model model) {
        Client client = new Client();
        model.addAttribute("isNew", true);
        model.addAttribute("client", client);
        return "client";
    }

    /**
     * Persist new client into persistence storage.
     *
     * @param client new client with filled data.
     * @return view name
     */
    @PostMapping(value = "/client")
    public String addClient(Client client) {
        this.clientService.add(client);
        return "redirect:/clients";
    }

    /**
     * Delete client.
     *
     * @return view name
     */
    @GetMapping(value = "/client/{id}/delete")
    public final String deleteClientById(@PathVariable Integer id, Model model) {
        clientService.delete(id);
        return "redirect:/clients";
    }


}