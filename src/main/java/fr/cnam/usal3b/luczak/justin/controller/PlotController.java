package fr.cnam.usal3b.luczak.justin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.cnam.usal3b.luczak.justin.form.PlotForm;
import fr.cnam.usal3b.luczak.justin.model.Plot;
import fr.cnam.usal3b.luczak.justin.repository.PlotRepository;

import fr.cnam.usal3b.luczak.justin.model.Etape;
import fr.cnam.usal3b.luczak.justin.repository.EtapeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class PlotController {

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private EtapeRepository etapeRepository;



    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value = { "/plotList" }, method = RequestMethod.GET)
    public String plotList(Model model) {

        Iterable<Plot> plotsDb = plotRepository.findAll();
        model.addAttribute("plot", plotsDb);

        return "plotList";
    }

    @RequestMapping(value = { "/addPlot" }, method = RequestMethod.GET)
    public String showAddPlotPage(Model model) {

        PlotForm plotForm = new PlotForm();
        model.addAttribute("plotForm", plotForm);

        Iterable<Etape> listeEtapes = etapeRepository.findAll();
        model.addAttribute("etapes", listeEtapes);

        return "addPlot";
    }

    @RequestMapping(value = { "/addPlot" }, method = RequestMethod.POST)
    public String savePlot(Model model, @ModelAttribute("PlotForm") PlotForm plotForm) {

        String titre = plotForm.getTitre();
        String description = plotForm.getDescription();
        // Optionnal est une aide pour traiter la réponse à la requête. Si le scénario
        // qu'on cherche existe, alors isPresent sera à true. Sinon à false. Evite les
        // problème de NullPointerException.
        Optional<Etape> etape = etapeRepository.findById(plotForm.getEtapeId());
        if (etape.isPresent() && titre != null && titre.length() > 0 // TODO si vous vous ennuyez : chercher @Valid
                && description != null && description.length() > 0) {
            Plot newPlot = new Plot(titre, description);
            // attention au .get() pour récupérer l'objet Scenario avec l'id remplie dans le
            // formulaire
            newPlot.setEtape(etape.get());
            plotRepository.save(newPlot);

            return "redirect:/etapeList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addplot";
    }
}
