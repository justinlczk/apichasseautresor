package fr.cnam.usal3b.luczak.justin.controller;

import fr.cnam.usal3b.luczak.justin.model.Etape;
import fr.cnam.usal3b.luczak.justin.model.Scenario;
import fr.cnam.usal3b.luczak.justin.repository.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.cnam.usal3b.luczak.justin.form.BriqueForm;
import fr.cnam.usal3b.luczak.justin.model.Brique;
import fr.cnam.usal3b.luczak.justin.repository.BriqueRepository;

import fr.cnam.usal3b.luczak.justin.model.Plot;
import fr.cnam.usal3b.luczak.justin.repository.PlotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BriqueController {


    @Autowired
    private BriqueRepository briqueRepository;
    @Autowired
    private PlotRepository plotRepository;


    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;



    @RequestMapping(value = { "/briqueList" }, method = RequestMethod.GET)
    public String briqueList(Model model) {

        Iterable<Brique> briquesDb = briqueRepository.findAll();
        model.addAttribute("brique", briquesDb);

        return "briqueList";
    }

    @RequestMapping(value = { "/addBrique" }, method = RequestMethod.GET)
    public String showAddBriquePage(Model model) {

        BriqueForm briqueForm = new BriqueForm();
        model.addAttribute("briqueForm", briqueForm);

        Iterable<Plot> listePlots = plotRepository.findAll();
        model.addAttribute("plots", listePlots);

        return "addBrique";
    }

    @RequestMapping(value = { "/addBrique" }, method = RequestMethod.POST)
    public String saveBrique(Model model, @ModelAttribute("BriqueForm") BriqueForm briqueForm) {

        String titre = briqueForm.getTitre();
        String description = briqueForm.getDescription();
        // Optionnal est une aide pour traiter la réponse à la requête. Si le scénario
        // qu'on cherche existe, alors isPresent sera à true. Sinon à false. Evite les
        // problème de NullPointerException.
        Optional<Plot> plot = plotRepository.findById(briqueForm.getPlotId());
        if (plot.isPresent() && titre != null && titre.length() > 0 // TODO si vous vous ennuyez : chercher @Valid
                && description != null && description.length() > 0) {
            Brique newBrique = new Brique(titre, description);
            // attention au .get() pour récupérer l'objet Scenario avec l'id remplie dans le
            // formulaire
            newBrique.setPlot(plot.get());
            briqueRepository.save(newBrique);

            return "redirect:/etapeList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addbrique";
    }
}
