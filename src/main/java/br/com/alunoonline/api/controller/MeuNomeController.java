package br.com.alunoonline.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meu-nome")
public class MeuNomeController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String exibirNome() {
        return "Kelson";
    }
}
