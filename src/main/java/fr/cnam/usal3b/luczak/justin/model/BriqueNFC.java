package fr.cnam.usal3b.luczak.justin.model;

import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class BriqueNFC extends Brique {
	private UUID identifiantNFC;

	public UUID getIdentifiantNFC() {
		return identifiantNFC;
	}

	public void setIdentifiantNFC(UUID identifiantNFC) {
		this.identifiantNFC = identifiantNFC;
	}
}
