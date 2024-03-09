package br.com.alunoonline.api.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AlunoDTO {


    private String nome;

    private String email;
}
