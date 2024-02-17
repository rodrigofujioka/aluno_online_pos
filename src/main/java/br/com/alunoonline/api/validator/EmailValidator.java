package br.com.alunoonline.api.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class EmailValidator implements
        ConstraintValidator<EmailValidation, String> {
    private String message;
    @Override
    public void initialize(EmailValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }


    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.nonNull(nome)){
            for(String curso : getCursosValidos()){
                if(curso.equalsIgnoreCase(nome))
                    return true;
            }
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(message + nome)//
                .addConstraintViolation();
        return false;
    }

    private List<String> getCursosValidos(){
        List<String> listaCursos = new ArrayList<>();
        listaCursos.add("Sistema");
        listaCursos.add("Direito");
        return listaCursos;
    }
}
