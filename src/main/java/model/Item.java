package model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private Date dataDevolucao;
    @ManyToOne
    private Emprestimo emprestimo;
    @ManyToOne
    private Exemplar exemplar;

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
