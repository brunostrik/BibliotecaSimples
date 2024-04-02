package dao;

import jakarta.persistence.Query;
import model.Emprestimo;

import java.util.List;

public class EmprestimoDAO extends SuperDAO<Emprestimo> {
    public List<Emprestimo> selectPendentes(){
        getEntityManager().getTransaction().begin();
        Query query = getEntityManager().createQuery("SELECT e FROM Emprestimo e WHERE e.dataDevolucao IS NULL");
        List<Emprestimo> items = query.getResultList();
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        return items;
    }
}
