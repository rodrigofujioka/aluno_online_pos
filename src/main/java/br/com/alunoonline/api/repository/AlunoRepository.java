package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByEmail(String email);
    Aluno findByNomeAndEmail(String nome, String email);
    @Query("select a from Aluno a order by a.nome asc")
    List<Aluno> listarTodosAlunosOrdenadoPorNome();
    @Query("select a from Aluno a where a.email= :email")
    Aluno buscarPorEmail(@Param("email") String email);






}
