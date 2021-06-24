package fr.cnam.usal3b.luczak.justin.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class BriqueGeoloc extends Brique {

	@OneToOne(mappedBy = "briqueGeoloc")
	private Coordonnees hautGauche;

	@OneToOne(mappedBy = "briqueGeoloc")
	private Coordonnees basDroite;

	public Coordonnees getHautGauche() {
		return hautGauche;
	}

	public void setHautGauche(Coordonnees hautGauche) {
		this.hautGauche = hautGauche;
	}

	public Coordonnees getBasDroite() {
		return basDroite;
	}

	public void setBasDroite(Coordonnees basDroite) {
		this.basDroite = basDroite;
	}

}
