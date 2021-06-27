package fr.cnam.usal3b.luczak.justin.form;


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

    public void setTypeBrique(enum type{ TEXTE, IMAGE }) {
        switch (type){
            case TEXTE:
                this.type = type.TEXTE;
                break;
            case IMAGE:
                this.type = type.IMAGE;
                break;
        }
    }
}
