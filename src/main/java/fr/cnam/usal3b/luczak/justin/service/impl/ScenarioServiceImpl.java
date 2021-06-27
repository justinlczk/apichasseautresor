package fr.cnam.usal3b.luczak.justin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cnam.usal3b.luczak.justin.model.Scenario;
import fr.cnam.usal3b.luczak.justin.service.ScenarioService;
import fr.cnam.usal3b.luczak.justin.repository.ScenarioRepository;

@Service
public class ScenarioServiceImpl implements ScenarioService {

	@Autowired
	private ScenarioRepository scenarioRepository;

	@Override
	public boolean validerDonnees(Scenario aValider) {
		if (aValider.getTitre() != null && !aValider.getTitre().isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public void sauvegarder(Scenario aSauvegarder) {
		scenarioRepository.save(aSauvegarder);

	}

	@Override
	public void supprimer(Scenario aSupprimer) {
		// TODO Auto-generated method stub
		scenarioRepository.delete(aSupprimer);
	}

	@Override
	public Scenario getUnObjet(Integer identifiant) {
		Optional<Scenario> scenario = scenarioRepository.findById(identifiant);

		if(scenario.isPresent() && !scenario.isEmpty())
			return scenario.get();
		else
			return null;
	}

	@Override
	public List<Scenario> getTout() {
		List<Scenario> listeScenario = new ArrayList<>();
		for (Scenario scenario : scenarioRepository.findAll()) {
			listeScenario.add(scenario);
		}
		return listeScenario;
	}

}
