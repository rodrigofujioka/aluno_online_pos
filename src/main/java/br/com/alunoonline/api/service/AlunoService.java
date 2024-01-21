package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public void create(Aluno aluno) {
        repository.save(aluno);
    }

    public Optional<Aluno> findById(Long id) {
        return repository.findById(id);
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, Aluno aluno) {
        Optional<Aluno> alunoFromDB = findById(id);

        if (alunoFromDB.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }

        Aluno alunoUpdated = alunoFromDB.get();

        alunoUpdated.setNome(aluno.getNome());
        alunoUpdated.setEmail(aluno.getEmail());
        alunoUpdated.setCurso(aluno.getCurso());

        repository.save(alunoUpdated);
    }


}
