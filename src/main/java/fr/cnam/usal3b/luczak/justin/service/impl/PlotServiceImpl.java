package fr.cnam.usal3b.luczak.justin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.cnam.usal3b.luczak.justin.repository.EtapeRepository;
import fr.cnam.usal3b.luczak.justin.service.EtapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cnam.usal3b.luczak.justin.model.*;
import fr.cnam.usal3b.luczak.justin.repository.PlotRepository;
import fr.cnam.usal3b.luczak.justin.service.PlotService;

@Service
public class PlotServiceImpl implements PlotService {
    @Autowired
    private PlotRepository plotRepository;

    @Override
    public boolean validerDonnees(Plot aValider) {
        if (aValider.getTitre() != null && !aValider.getTitre().isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void sauvegarder(Plot aSauvegarder) {
        plotRepository.save(aSauvegarder);
    }

    @Override
    public void supprimer(Plot aSupprimer) {
        plotRepository.delete(aSupprimer);
    }

    @Override
    public Plot getUnObjet(Integer identifiant) {
        Optional<Plot> plot = plotRepository.findById(identifiant);

        if(plot.isPresent() && !plot.isEmpty())
            return plot.get();
        else
            return null;
    }

    @Override
    public List<Plot> getTout() {
        List<Plot> listePlots = new ArrayList<>();
        for (Plot plot : plotRepository.findAll()) {
            listePlots.add(plot);
        }
        return listePlots;
    }
}
