package fr.cnam.usal3b.luczak.justin.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "titre", "description", "type" })
public class BriqueJson {

    @JsonIgnore
    private Brique brique;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public BriqueJson() {
    }

    @Enumerated(EnumType.STRING)
    private TypeBriqueEnum typeBrique;

    public BriqueJson(Brique brique) {
        this.brique = brique;
    }

    @JsonProperty("titre")
    public String getTitre() {
        return brique.getTitre();
    }

    @JsonProperty("titre")
    public void setTitre(String titre) {
        brique.setTitre(titre);
    }

    @JsonProperty("description")
    public String getDescription() {
        return brique.getDescription();
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        brique.setDescription(description);
    }

    @JsonProperty("type")
    public TypeBriqueEnum getTypeBrique() {
        return typeBrique;
    }

    @JsonProperty("type")
    public void setTypeBrique(TypeBriqueEnum typeBrique) {
        this.typeBrique = typeBrique;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonIgnore
    public Brique getBrique() {
        return brique;
    }

    @JsonIgnore
    public void setBrique(Brique brique) {
        this.brique = brique;
    }

}
