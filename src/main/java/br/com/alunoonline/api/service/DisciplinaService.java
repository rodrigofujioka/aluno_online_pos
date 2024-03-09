package br.com.alunoonline.api.service;

import br.com.alunoonline.api.client.DisciplinaClient;
import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.dto.DisciplinaIntegrationDTO;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;
    @Autowired
    DisciplinaClient client;

    public void create(Disciplina disciplina) {
        repository.save(disciplina);
    }

    public void atualizar(Disciplina disciplina) {
        if(disciplina.getId()==null){
          throw new RuntimeException("ID não preenchido");
        }
        repository.save(disciplina);
    }

    public List<Disciplina> listarPorEmailProfessor(String email){
        return repository.listarDisciplinasPorProfessor(email);
    }

    public List<Disciplina> listar(){
        return repository.findAll();
    }

     public void importarDisciplinas(){
        log.info("Integração iniciada");
        List<DisciplinaIntegrationDTO> lista = client.getListaDisciplina();
        for(DisciplinaIntegrationDTO disciplinaDTO : lista){
            var disciplina = new Disciplina();
            disciplina.setNome(disciplinaDTO.getCodigo() +" - "+ disciplinaDTO.getNome());
            repository.save(disciplina);
            log.info("Disciplina {} integrada ", disciplinaDTO.getNome());
        }
         log.info("Integração concluída");
     }


}
