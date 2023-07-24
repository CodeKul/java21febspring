package com.codekul.java21febspring.dbrefmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SportsController {

    @Autowired
    private SportsRepo sportsRepo;

    @PostMapping("saveSport")
    public String saveSports(@RequestBody Sports sports){
        sportsRepo.save(sports);
        return "sport saved";
    }
}
