package fr.cnam.usal3b.luczak.justin.model;

import javax.persistence.*;

@MappedSuperclass
public class Brique {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    protected String titre;
    protected String description;

    @Enumerated(EnumType.STRING)
    protected TypeBriqueEnum typeBrique;

    @ManyToOne
    @JoinColumn(name = "plot_id", nullable = false)
    protected Plot plot;

    public Brique() {
    }

    public Brique(String titre, String description, TypeBriqueEnum type) {
        this.titre = titre;
        this.description = description;
        this.typeBrique = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeBriqueEnum getTypeBrique() { return typeBrique; }

    public void setTypeBrique(TypeBriqueEnum type) {
        this.typeBrique = type;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

}