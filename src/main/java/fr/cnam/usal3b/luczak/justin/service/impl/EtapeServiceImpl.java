package fr.cnam.usal3b.luczak.justin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cnam.usal3b.luczak.justin.model.Etape;
import fr.cnam.usal3b.luczak.justin.model.Scenario;
import fr.cnam.usal3b.luczak.justin.repository.EtapeRepository;
import fr.cnam.usal3b.luczak.justin.service.EtapeService;

@Service
public class EtapeServiceImpl implements EtapeService {
	@Autowired
	private EtapeRepository etapeRepository;

	@Override
	public boolean validerDonnees(Etape aValider) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sauvegarder(Etape aSauvegarder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer(Etape aSupprimer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Etape getUnObjet(Integer identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etape> getTout() {
		List<Etape> listeEtapes = new ArrayList<>();
		for (Etape etape : etapeRepository.findAll()) {
			listeEtapes.add(etape);
		}
		return listeEtapes;
	}

	@Override
	public List<Etape> getEtapesPourScenario(Scenario scenario) {
		List<Etape> listeEtapes = new ArrayList<>();
		for (Etape etape : etapeRepository.findByScenario(scenario)) {
			listeEtapes.add(etape);
		}
		return listeEtapes;
	}

}
