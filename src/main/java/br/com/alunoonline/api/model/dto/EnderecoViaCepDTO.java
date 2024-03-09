package br.com.alunoonline.api.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoViaCepDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String uf;
}


