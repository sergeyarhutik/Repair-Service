package com.epam.brest.summer.courses2019.web_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Device controller.
 */
@Controller
public class ClientController {

    @GetMapping("/clients")
    public String clients() {
        return "clients";
    }

}