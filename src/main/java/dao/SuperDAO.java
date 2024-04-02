package dao;

import jakarta.persistence.*;

import java.util.List;

public abstract class SuperDAO<T> {
    private static EntityManagerFactory emf;
    private EntityManager em;

    protected EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("default");
        }
        if (!emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf;
    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            em = getEntityManagerFactory().createEntityManager();
        }
        if(!em.isOpen()){
            em = getEntityManagerFactory().createEntityManager();
        }
        return em;
    }

    public List<T> selectAll(Class<T> classe) {
        getEntityManager().getTransaction().begin();
        Query query = getEntityManager().createQuery("SELECT a FROM " + classe.getSimpleName() + " a");
        List<T> items = query.getResultList();
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        return items;
    }

    public T selectOne(Class<T> classe, int id) {
        getEntityManager().getTransaction().begin();
        T a = getEntityManager().find(classe, id);
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        getEntityManagerFactory().close();
        return a;
    }

    public void persist(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        getEntityManagerFactory().close();
    }
    public void merge(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        getEntityManagerFactory().close();
    }


}
