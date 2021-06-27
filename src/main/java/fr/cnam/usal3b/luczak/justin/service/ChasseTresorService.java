package fr.cnam.usal3b.luczak.justin.service;

import java.util.List;

public interface ChasseTresorService<T> {

	boolean validerDonnees(T aValider);

	void sauvegarder(T aSauvegarder);

	void supprimer(T aSupprimer);

	T getUnObjet(Integer identifiant);

	List<T> getTout();

}
