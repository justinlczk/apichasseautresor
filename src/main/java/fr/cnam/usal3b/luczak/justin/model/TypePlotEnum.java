package fr.cnam.usal3b.luczak.justin.model;

public enum TypePlotEnum {
    /**
     * Représente une interlude
     */
    INTERLUDE(true, "INTERLUDE"),
    /**
     * Représente une brique Question
     */
    QUESTION(true, "QUESTION"),
    /**
     * Représente un choix de réponse
     */
    CHOIX_REPONSE(false, "CHOIX_REPONSE"),
    /**
     * Représente une réponse juste
     */
    REPONSE_JUSTE(false, "REPONSE_JUSTE"),
    /**
     * Représente une réponse fausse
     */
    REPONSE_FAUSSE(false, "REPONSE_FAUSSE");

    private boolean peutDebuterEtape;
    private String typePlot;

    private TypePlotEnum(boolean peutDebuterEtape, String typePlot) {
        this.peutDebuterEtape = peutDebuterEtape;
        this.typePlot = typePlot;
    }

    public boolean isPeutDebuterEtape() {
        return peutDebuterEtape;
    }

    public String getType() {
        return typePlot;
    }

}
