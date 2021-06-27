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
import org.springframework.beans.factory.annotation.Qualifier;


import fr.cnam.usal3b.luczak.justin.form.BriqueForm;
import fr.cnam.usal3b.luczak.justin.model.Brique;
import fr.cnam.usal3b.luczak.justin.model.BriqueTexte;
import fr.cnam.usal3b.luczak.justin.model.Plot;
import fr.cnam.usal3b.luczak.justin.repository.PlotRepository;
import fr.cnam.usal3b.luczak.justin.service.BriqueService;
import fr.cnam.usal3b.luczak.justin.service.CommonBriqueService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class BriqueController {

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private CommonBriqueService commonBriqueService;

    @Autowired
    @Qualifier("briqueTexteServiceImpl")
    private BriqueService<BriqueTexte> briqueTexteService;

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/briqueList" }, method = RequestMethod.GET)
    public String briqueList(Model model) {

        Iterable<? extends Brique> briquesDb = commonBriqueService.getAllBriques();
        model.addAttribute("briques", briquesDb);

        return "briqueList";
    }

    @RequestMapping(value = { "/addBrique" }, method = RequestMethod.GET)
    public String showAddBriquePage(Model model) {

        BriqueForm briqueForm = new BriqueForm();
        model.addAttribute("briqueForm", briqueForm);
        model.addAttribute("plots", plotRepository.findAll());

        return "addBrique";
    }

    @RequestMapping(value = { "/addBrique" }, method = RequestMethod.POST)
    public String saveBrique(Model model, @ModelAttribute("briqueForm") BriqueForm briqueForm) {

        String titre = briqueForm.getTitre();
        String description = briqueForm.getDescription();
        Optional<Plot> plot = plotRepository.findById(briqueForm.getPlotId());
        if (plot.isPresent() && titre != null && titre.length() > 0 && description != null
                && description.length() > 0) {
            switch (briqueForm.getTypeBrique()) {
                case TEXTE:
                    //String contenu = briqueForm.
                    BriqueTexte newBrique = new BriqueTexte();
                    newBrique.setTitre(titre);
                    newBrique.setDescription(description);
                    newBrique.setPlot(plot.get());
                    //newBrique.setContenuHtml(contenu);
                    briqueTexteService.sauvegarder(newBrique);
                    break;

                default:
                    break;
            }

            return "redirect:/briqueList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addBrique";
    }

}

