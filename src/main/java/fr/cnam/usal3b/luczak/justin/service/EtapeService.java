package fr.cnam.usal3b.luczak.justin.service;

import java.util.List;

import fr.cnam.usal3b.luczak.justin.model.Etape;
import fr.cnam.usal3b.luczak.justin.model.Scenario;

public interface EtapeService extends ChasseTresorService<Etape> {

	List<Etape> getEtapesPourScenario(Scenario scenario);

}
