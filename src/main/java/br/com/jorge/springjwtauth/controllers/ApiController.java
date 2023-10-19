package br.com.jorge.springjwtauth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/get")
    public ResponseEntity get() {
        return ResponseEntity.ok("Carrega registro se estiver autenticado e com role admin.");
    }

}
