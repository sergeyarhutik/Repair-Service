package com.epam.brest.summer.courses2019.web_app;

import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Device controller.
 */
@Controller
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;



    /**
     * Goto edit client page.
     *
     * @return view name
     */
    @GetMapping(value = "/client/{id}")
    public final String gotoEditClientPage(@PathVariable Integer id, Model model) {

        LOGGER.debug("gotoEditClientPage({},{})", id, model);
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client";
    }

    /**
     * Update device into persistence storage.
     *
     * @return view name
     */
    @PostMapping(value = "/client/{id}")
    public String updateClient(Client client,
                                   BindingResult result) {

        LOGGER.debug("updateClient({}, {})", client, result);
            clientService.update(client);
            return "redirect:/clients";
    }

    /**
     * Goto add client page.
     *
     * @return view name
     */
    @GetMapping(value = "/client")
    public final String gotoAddClientPage(Model model) {

        LOGGER.debug("gotoAddClientmentPage({})", model);
        Client client = new Client();
        model.addAttribute("isNew", true);
        model.addAttribute("client", client);
        return "client";
    }

    /**
     * Persist new client into persistence storage.
     *
     * @param client new client with filled data.
     * @param result     binding result.
     * @return view name
     */
    @PostMapping(value = "/client")
    public String addClient(Client client,
                                BindingResult result) {

        LOGGER.debug("addClient({}, {})", client, result);
        clientService.add(client);
        return "redirect:/clients";
    }

    /**
     * Delete client.
     *
     * @return view name
     */
    @GetMapping(value = "/client/{id}/delete")
    public final String deleteClientById(@PathVariable Integer id, Model model) {
        LOGGER.debug("delete({},{})", id, model);
        clientService.delete(id);
        return "redirect:/clients";
    }
}