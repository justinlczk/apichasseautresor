package fr.cnam.usal3b.luczak.justin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cnam.usal3b.luczak.justin.model.BriqueTexte;
import fr.cnam.usal3b.luczak.justin.model.Plot;
import fr.cnam.usal3b.luczak.justin.repository.BriqueTexteRepository;

@Service
public class BriqueTexteServiceImpl extends AbstractBriqueServiceImpl<BriqueTexte> {
	@Autowired
	private BriqueTexteRepository briqueTexteRepository;

	@Override
	public List<BriqueTexte> getTout() {
		List<BriqueTexte> listeBriques = new ArrayList<>();
		for (BriqueTexte briqueTexte : briqueTexteRepository.findAll()) {
			listeBriques.add(briqueTexte);
		}
		return listeBriques;
	}

	@Override
	public boolean validerDonnees(BriqueTexte aValider) {
		if (super.validerDonnees(aValider) && aValider.getContenuHtml() != null && !aValider.getContenuHtml().isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public void sauvegarder(BriqueTexte aSauvegarder) {
		briqueTexteRepository.save(aSauvegarder);

	}

	@Override
	public void supprimer(BriqueTexte aSupprimer) {
		// TODO Auto-generated method stub
		briqueTexteRepository.delete(aSupprimer);
	}

	@Override
	public BriqueTexte getUnObjet(Integer identifiant) {
		// TODO Auto-generated method stub
		briqueTexteRepository.findById(identifiant);
		return null;
	}

	@Override
	public List<BriqueTexte> getBriquesPourPlot(Plot plot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean validerCompletion() {
		// TODO Auto-generated method stub
		return false;
	}

}
