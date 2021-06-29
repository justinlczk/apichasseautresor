package fr.cnam.usal3b.luczak.justin.model;

import java.util.ArrayList;
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
public class PlotJson {

    @JsonIgnore
    private Plot plot;

    @JsonProperty("briqueTextes")
    private List<BriqueJson> briques;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public PlotJson() {
    }

    @Enumerated(EnumType.STRING)
    private TypePlotEnum typePlot;

    public PlotJson(Plot plot) {
        this.plot = plot;
    }

    @JsonProperty("titre")
    public String getTitre() {
        return plot.getTitre();
    }

    @JsonProperty("titre")
    public void setTitre(String titre) {
        plot.setTitre(titre);
    }

    @JsonProperty("description")
    public String getDescription() {
        return plot.getDescription();
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        plot.setDescription(description);
    }

    @JsonProperty("type")
    public TypePlotEnum getTypePlot() {
        return typePlot;
    }

    @JsonProperty("type")
    public void setTypePlot(TypePlotEnum typePlot) {
        this.typePlot = typePlot;
    }


    @JsonProperty("briqueTextes")
    public List<BriqueJson> getBrique() {
        briques = new ArrayList<BriqueJson>();
        for (Brique brique : plot.getBriqueTextes()) {
            briques.add(new BriqueJson(brique));
        }
        return briques;
    }

    @JsonProperty("briqueTextes")
    public void setBriques(List<BriqueJson> briques) {
        this.briques = briques;
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
    public Plot getPlot() {
        return plot;
    }

    @JsonIgnore
    public void setPlot(Plot plot) {
        this.plot = plot;
    }

}
