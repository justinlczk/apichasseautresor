package fr.cnam.usal3b.luczak.justin.repository;

import fr.cnam.usal3b.luczak.justin.model.Brique;
import fr.cnam.usal3b.luczak.justin.model.Plot;
import org.springframework.data.repository.CrudRepository;

import fr.cnam.usal3b.luczak.justin.model.BriqueTexte;

import java.util.List;

public interface BriqueTexteRepository extends CrudRepository<BriqueTexte, Integer> {
    List<BriqueTexte> findByPlot(Plot plot);
}