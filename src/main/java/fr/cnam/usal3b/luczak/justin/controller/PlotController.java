package fr.cnam.usal3b.luczak.justin.controller;

import fr.cnam.usal3b.luczak.justin.model.EtapeJson;
import fr.cnam.usal3b.luczak.justin.model.TypePlotEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.cnam.usal3b.luczak.justin.form.PlotForm;
import fr.cnam.usal3b.luczak.justin.model.Plot;
import fr.cnam.usal3b.luczak.justin.repository.PlotRepository;
import fr.cnam.usal3b.luczak.justin.model.PlotJson;

import fr.cnam.usal3b.luczak.justin.model.Etape;
import fr.cnam.usal3b.luczak.justin.repository.EtapeRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class PlotController {

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private EtapeRepository etapeRepository;

    @Enumerated(EnumType.STRING)
    private TypePlotEnum typePlot;

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value = { "/plotList" }, method = RequestMethod.GET)
    public String plotList(Model model) {

        Iterable<Plot> plotsDb = plotRepository.findAll();
        model.addAttribute("plots", plotsDb);

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
        TypePlotEnum typePLot = plotForm.getTypePlot();
        // Optionnal est une aide pour traiter la réponse à la requête. Si le scénario
        // qu'on cherche existe, alors isPresent sera à true. Sinon à false. Evite les
        // problème de NullPointerException.
        Optional<Etape> etape = etapeRepository.findById(plotForm.getEtapeId());
        if (etape.isPresent() && titre != null && titre.length() > 0 // TODO si vous vous ennuyez : chercher @Valid
                && description != null && description.length() > 0) {
            Plot newPlot = new Plot(titre, description, typePLot);
            // attention au .get() pour récupérer l'objet Scenario avec l'id remplie dans le
            // formulaire

            newPlot.setEtape(etape.get());
            plotRepository.save(newPlot);

            return "redirect:/plotList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addplot";
    }

    @RequestMapping(value = {"/plotListJson"}, method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<PlotJson>> plotListJson() {
        List<PlotJson> listePlots = new ArrayList<PlotJson>();
        for (Plot plot : plotRepository.findAll()) {
            listePlots.add(new PlotJson(plot));
        }
        return ResponseEntity.ok(listePlots);
    }

    @RequestMapping(value = {"/plotJson/{id}"}, method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<PlotJson> plotJson(@PathVariable("id") Integer id) {
        Optional<Plot> plot = plotRepository.findById(id);
        if (plot.isPresent())
            return ResponseEntity.ok(new PlotJson(plot.get()));
        else
            return ResponseEntity.noContent().build();
    }
}
