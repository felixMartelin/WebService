package com.example.demo.Controller;

import com.example.demo.Service.PersonnageService;
import com.example.demo.Service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RealisateurController {
    @Autowired
    private RealisateurService service;

    public RealisateurController(RealisateurService serv){
        this.service = serv;
    }
}
