package fr.cnam.usal3b.luczak.justin.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import fr.cnam.usal3b.luczak.justin.model.Etape;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "titre", "description" })
public class EtapeJson {

	@JsonIgnore
	private Etape etape;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	public EtapeJson() {
	}

	public EtapeJson(Etape etape) {
		this.etape = etape;
	}

	@JsonProperty("titre")
	public String getTitre() {
		return etape.getTitre();
	}

	@JsonProperty("titre")
	public void setTitre(String titre) {
		etape.setTitre(titre);
	}

	@JsonProperty("description")
	public String getDescription() {
		return etape.getDescription();
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		etape.setDescription(description);
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
	public Etape getEtape() {
		return etape;
	}

	@JsonIgnore
	public void setEtape(Etape etape) {
		this.etape = etape;
	}

}
