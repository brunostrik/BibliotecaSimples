package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Titulo {
    @Id
    @GeneratedValue
    private int id;
    private int prazo;
    private String titulo;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Area area;

    @OneToMany
    @JoinColumn(name="titulo_id")
    private List<Exemplar> exemplares;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }
}
