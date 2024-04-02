package dao;

import model.Exemplar;
import model.Titulo;

public class ExemplarDAO extends SuperDAO<Exemplar> {
    public void cadastrarVarios(Titulo titulo, int qtdBiblioteca, int qtdEmprestavel){
        getEntityManager().getTransaction().begin();
        for(int i=0;i<qtdBiblioteca;i++){
            //cria exemplares de biblioteca
            Exemplar e = new Exemplar();
            e.setTitulo(titulo);
            e.setExemplarBiblioteca(true);
            getEntityManager().persist(e);
        }
        for(int i=0;i<qtdEmprestavel;i++){
            //cria exemplares emprestaveis
            Exemplar e = new Exemplar();
            e.setTitulo(titulo);
            e.setExemplarBiblioteca(false);
            getEntityManager().persist(e);
        }
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        getEntityManagerFactory().close();
    }
}
