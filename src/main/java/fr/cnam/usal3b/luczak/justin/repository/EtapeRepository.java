package fr.cnam.usal3b.luczak.justin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.cnam.usal3b.luczak.justin.model.Etape;
import fr.cnam.usal3b.luczak.justin.model.Scenario;

public interface EtapeRepository extends CrudRepository<Etape, Integer> {

    List<Etape> findByScenario(Scenario scenario);
}