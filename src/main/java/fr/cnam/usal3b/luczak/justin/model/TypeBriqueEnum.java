package fr.cnam.usal3b.luczak.justin.model;

public enum TypeBriqueEnum {
    GEOLOC("GEOLOC"),
    IMAGE("IMAGE"),
    NFC("NFC"),
    TEXTE("TEXTE"),
    VIDEO("VIDEO");

    private String type;

    private TypeBriqueEnum(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

}
