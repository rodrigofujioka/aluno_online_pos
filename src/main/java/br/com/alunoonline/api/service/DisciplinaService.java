package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public void create(Disciplina disciplina) {
        repository.save(disciplina);
    }


    public List<Disciplina> listarPorEmailProfessor(String email){
        return repository.listarDisciplinasPorProfessor(email);
    }

}
