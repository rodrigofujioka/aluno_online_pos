package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Disciplina disciplina) {
        service.create(disciplina);
    }

    @GetMapping("/professor/email/{email}/asc")
    public List<Disciplina> listarPorEmailProfessor(@PathVariable String email){
        return service.listarPorEmailProfessor(email);
    }

    @GetMapping
    public List<Disciplina> getDisciplinas(){
        return service.listar();
    }

    @PostMapping("/importar")
    public void importarDisciplinas(){
        service.importarDisciplinas();
    }


}
