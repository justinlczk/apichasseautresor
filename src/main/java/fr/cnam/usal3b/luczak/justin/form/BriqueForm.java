package fr.cnam.usal3b.luczak.justin.form;


import fr.cnam.usal3b.luczak.justin.model.TypeBriqueEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class BriqueForm {
    private String titre;
    private String description;
    private Integer plotId;

    @Enumerated(EnumType.STRING)
    private TypeBriqueEnum typeBrique;

    private String contenu;

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

    public Integer getPlotId() {
        return plotId;
    }

    public void setPlotId(Integer plotId) {
        this.plotId = plotId;
    }

    public TypeBriqueEnum getTypeBrique() { return typeBrique; }

    public void setTypeBrique(TypeBriqueEnum type) {
        this.typeBrique = type;
    }

    public String getContenu() { return contenu; }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
