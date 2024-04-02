package dao;

import jakarta.persistence.Query;
import model.Aluno;
import model.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends SuperDAO<Aluno> {
    public List<Aluno> selectSemDebito(){
        getEntityManager().getTransaction().begin();
        Query query = getEntityManager().createQuery("SELECT a from Aluno a " +
                                                        "WHERE a NOT IN(" +
                                                        "    SELECT e.aluno from Emprestimo e" +
                                                        "                             where e.dataDevolucao IS NULL" +
                                                        "                             and e.dataPrevista < CURRENT_DATE" +
                                                        "    )");
        List<Aluno> serasa = query.getResultList(); //pega os emprestimos pendentes
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        return serasa;
    }
}
