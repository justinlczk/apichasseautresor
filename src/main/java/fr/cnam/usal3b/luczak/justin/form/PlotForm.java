package fr.cnam.usal3b.luczak.justin.form;

import fr.cnam.usal3b.luczak.justin.model.TypePlotEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PlotForm {
    @Enumerated(EnumType.STRING)
    private String titre;
    private String description;
    private TypePlotEnum typePlot;

    private Integer etapeId;

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

    public TypePlotEnum getTypePlot() {
        return typePlot;
    }

    public void setTypePlot(TypePlotEnum typePlot) {
        this.typePlot = typePlot;
    }


    public Integer getEtapeId() {
        return etapeId;
    }

    public void setEtapeId(Integer etapeId) {
        this.etapeId = etapeId;
    }

}
