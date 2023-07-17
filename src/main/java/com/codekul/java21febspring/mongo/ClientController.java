package com.codekul.java21febspring.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {


    @Autowired
    private ClientRepo clientRepo;

    @PostMapping("saveClient")
    public String saveClient(@RequestBody Client client){
        clientRepo.save(client);
        return "client saved";
    }
}
