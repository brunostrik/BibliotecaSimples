package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Exemplar {
    @Id
    @GeneratedValue
    private int id;
    private boolean exemplarBiblioteca;
    @ManyToOne
    private Titulo titulo;
    @OneToMany
    @JoinColumn(name = "exemplar_id")
    private List<Item> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isExemplarBiblioteca() {
        return exemplarBiblioteca;
    }

    public void setExemplarBiblioteca(boolean exemplarBiblioteca) {
        this.exemplarBiblioteca = exemplarBiblioteca;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
