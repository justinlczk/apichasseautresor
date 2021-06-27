package fr.cnam.usal3b.luczak.justin.form;


import fr.cnam.usal3b.luczak.justin.model.TypeBriqueEnum;

public class BriqueForm {
    private String titre;
    private String description;
    private Integer plotId;
    private String type;

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

    public String getTypeBrique() { return type; }

    public void setTypeBrique(TypeBriqueEnum type) {
        this.type = type;
    }
}
