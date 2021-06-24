package fr.cnam.usal3b.luczak.justin.model;

import javax.persistence.Entity;

@Entity
public class BriqueVideo extends Brique {
	private String urlVideo;
	private String texteAccessibilite;

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getTexteAccessibilite() {
		return texteAccessibilite;
	}

	public void setTexteAccessibilite(String texteAccessibilite) {
		this.texteAccessibilite = texteAccessibilite;
	}

}
