package fr.cnam.usal3b.luczak.justin.model;

import javax.persistence.*;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titre;
    private String description;
    @Enumerated(EnumType.STRING)
    private TypePlotEnum typePlot;


    @ManyToOne
    @JoinColumn(name = "etape_id", nullable = false)
    private Etape etape;


    @OneToMany(mappedBy = "plot")
    private List<BriqueTexte> briqueTextes;

    @OneToMany(mappedBy = "plot")
    private List<BriqueGeoloc> briqueGeolocs;

    @OneToMany(mappedBy = "plot")
    private List<BriqueImage> briqueImages;

    @OneToMany(mappedBy = "plot")
    private List<BriqueNFC> briqueNFCS;

    @OneToMany(mappedBy = "plot")
    private List<BriqueVideo> briqueVideos;


    public Plot() {
    }

    public Plot(String titre, String description) {
        this.titre = titre;
        this.description = description;
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

    public TypePlotEnum getTypePlot() {
        return typePlot;
    }

    public void setTypePlot(TypePlotEnum typePlot) {
        this.typePlot = typePlot;
    }

    public Etape getEtape() {
        return etape;
    }

    public void setEtape(Etape etape) {
        this.etape = etape;
    }

    public List<BriqueTexte> getBriqueTextes() {
        return briqueTextes;
    }

    public void setBriqueTextes(List<BriqueTexte> briqueTextes) {
        this.briqueTextes = briqueTextes;
    }

    public List<BriqueGeoloc> getBriqueGeolocs() {
        return briqueGeolocs;
    }

    public void setBriqueGeolocs(List<BriqueGeoloc> briqueGeolocs) {
        this.briqueGeolocs = briqueGeolocs;
    }

    public List<BriqueImage> getBriqueImages() {
        return briqueImages;
    }

    public void setBriqueImages(List<BriqueImage> briqueImages) {
        this.briqueImages = briqueImages;
    }

    public List<BriqueNFC> getBriqueNFCS() {
        return briqueNFCS;
    }

    public void setBriqueNFCS(List<BriqueNFC> briqueNFCS) {
        this.briqueNFCS = briqueNFCS;
    }

    public List<BriqueVideo> getBriqueVideos() {
        return briqueVideos;
    }

    public void setBriqueVideos(List<BriqueVideo> briqueVideos) {
        this.briqueVideos = briqueVideos;
    }
}
