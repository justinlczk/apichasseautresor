package fr.cnam.usal3b.luczak.justin.model;

public enum TypePlotEnum {
    /**
     * Représente une interlude
     */
    INTERLUDE(true),
    /**
     * Représente une brique Question
     */
    QUESTION(true),
    /**
     * Représente un choix de réponse
     */
    CHOIX_REPONSE(false),
    /**
     * Représente une réponse juste
     */
    REPONSE_JUSTE(false),
    /**
     * Représente une réponse fausse
     */
    REPONSE_FAUSSE(false);

    private boolean peutDebuterEtape;

    private TypePlotEnum(boolean peutDebuterEtape) {
        this.peutDebuterEtape = peutDebuterEtape;
    }

    public boolean isPeutDebuterEtape() {
        return peutDebuterEtape;
    }

}
