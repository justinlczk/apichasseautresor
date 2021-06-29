package fr.cnam.usal3b.luczak.justin.repository;

import fr.cnam.usal3b.luczak.justin.model.Etape;
import org.springframework.data.repository.CrudRepository;

import fr.cnam.usal3b.luczak.justin.model.Plot;

import java.util.List;

public interface PlotRepository extends CrudRepository<Plot, Integer> {
    List<Plot> findByEtape(Etape etape);
}