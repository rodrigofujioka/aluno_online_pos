package br.com.alunoonline.api.client;

import br.com.alunoonline.api.model.dto.DisciplinaIntegrationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "disciplina", url = "http://localhost:9090")
public interface DisciplinaClient {


   @GetMapping("/disciplina/{codigo}")
    public DisciplinaIntegrationDTO getDisciplina(@PathVariable String codigo);

    @GetMapping("/disciplina")
    public List<DisciplinaIntegrationDTO> getListaDisciplina();

    @GetMapping("/disciplina/disponiveis")
    public List<String> getListaCodigo();
}
