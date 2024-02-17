package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.dto.AlunoDTO;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.modelmapper.ModelMapper;
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
    ModelMapper mapper = new ModelMapper();

    public AlunoDTO consultaAlunoEmail(Long id){
        Aluno aluno = repository.findById(id).get();
        AlunoDTO alunoDTO = mapper.map(aluno, AlunoDTO.class);
      return alunoDTO;
    }

    public void create(Aluno aluno) {
        repository.save(aluno);
    }

    public Optional<Aluno> findById(Long id) {
        return repository.findById(id);
    }


    public Aluno buscarPorEmail(String email){
        return repository.findByEmail(email);
    }

    public Aluno buscarPorEmailJPQL(String email){
        return repository.buscarPorEmail(email);
    }
    public List<Aluno> listarTodosOrdenadaPorNome(){
        return repository.listarTodosAlunosOrdenadoPorNome();
    }
    public Aluno buscarPorNomeEmail(String nome, String email){
        return repository.findByNomeAndEmail(nome, email);
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
