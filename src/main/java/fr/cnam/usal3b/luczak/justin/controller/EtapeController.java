package fr.cnam.usal3b.luczak.justin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.cnam.usal3b.luczak.justin.form.ScenarioForm;
import fr.cnam.usal3b.luczak.justin.model.*;
import fr.cnam.usal3b.luczak.justin.service.BriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.cnam.usal3b.luczak.justin.form.EtapeForm;
import fr.cnam.usal3b.luczak.justin.repository.EtapeRepository;

import fr.cnam.usal3b.luczak.justin.repository.PlotRepository;

import fr.cnam.usal3b.luczak.justin.repository.ScenarioRepository;

import fr.cnam.usal3b.luczak.justin.service.EtapeService;


@Controller
public class EtapeController {

    @Autowired
    private EtapeRepository etapeRepository;
    @Autowired
    private PlotRepository plotRepository;
    @Autowired
    private ScenarioRepository scenarioRepository;

    @Autowired
    private EtapeService etapeService;


    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/etapeList"}, method = RequestMethod.GET)
    public String etapeList(Model model) {

        Iterable<Etape> etapesDb = etapeRepository.findAll();
        model.addAttribute("etapes", etapesDb);

        return "etapeList";
    }

    @RequestMapping(value = {"/addEtape"}, method = RequestMethod.GET)
    public String showAddEtapePage(Model model) {

        EtapeForm etapeForm = new EtapeForm();
        model.addAttribute("etapeForm", etapeForm);

        Iterable<Scenario> listeScenarios = scenarioRepository.findAll();
        model.addAttribute("scenarios", listeScenarios);

        return "addEtape";
    }

    @RequestMapping(value = {"/addEtape"}, method = RequestMethod.POST)
    public String saveEtape(Model model, @ModelAttribute("etapeForm") EtapeForm etapeForm) {

        String titre = etapeForm.getTitre();
        String description = etapeForm.getDescription();
        // Optionnal est une aide pour traiter la réponse à la requête. Si le scénario
        // qu'on cherche existe, alors isPresent sera à true. Sinon à false. Evite les
        // problème de NullPointerException.
        Optional<Scenario> scenario = scenarioRepository.findById(etapeForm.getScenarioId());
        if (scenario.isPresent() && titre != null && titre.length() > 0 // TODO si vous vous ennuyez : chercher @Valid
                && description != null && description.length() > 0) {
            Etape newEtape = new Etape(titre, description);
            // attention au .get() pour récupérer l'objet Scenario avec l'id remplie dans le
            // formulaire
            newEtape.setScenario(scenario.get());
            etapeRepository.save(newEtape);

            return "redirect:/etapeList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addEtape";
    }

    @RequestMapping(value = {"/updateetape/{id}"}, method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<Etape> etape = etapeRepository.findById(id);
        EtapeForm etapeForm = new EtapeForm();
        if (etape.isPresent()) {

            etapeForm.setId(etape.get().getId());
            etapeForm.setTitre(etape.get().getTitre());
            etapeForm.setDescription(etape.get().getDescription());
            model.addAttribute("etapeForm", etapeForm);
            model.addAttribute("libelleAction", "Modifier");
            Iterable<Plot> plotDb = plotRepository.findByEtape(etape.get());
            model.addAttribute("plots", plotDb);
        } else {
            model.addAttribute("errorMessage", "Pas d'étape avec cet id");
        }
        return "addEtape";
    }

    @RequestMapping(value = {"/deleteetape"}, params = {"id"}, method = RequestMethod.GET)
    public String deleteEtape(@RequestParam("id") Integer id, Model model) {

        Optional<Etape> etape = Optional.ofNullable(etapeService.getUnObjet(id));
        if (etape.isPresent() && !etape.isEmpty()) {
            etapeService.supprimer(etape.get());
            return "redirect:/briqueList";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "listEtape";
    }


    @RequestMapping(value = {"/showetape/{id}"}, method = RequestMethod.GET)
    public String showEtape(@PathVariable("id") Integer id, Model model) {
        Optional<Etape> etape = etapeRepository.findById(id);
        if (etape.isPresent() && !etape.isEmpty()) {
            Iterable<Plot> plotsDb = plotRepository.findByEtape(etape.get());
            model.addAttribute("plots", plotsDb);
            model.addAttribute("etape", etape.get());
        }

        model.addAttribute("errorMessage", errorMessage);
        return "showEtape";
    }

    @RequestMapping(value = {"/etapeListJson"}, method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<EtapeJson>> etapeListJson() {
        List<EtapeJson> listeEtapes = new ArrayList<EtapeJson>();
        for (Etape etape : etapeRepository.findAll()) {
            listeEtapes.add(new EtapeJson(etape));
        }
        return ResponseEntity.ok(listeEtapes);
    }

    @RequestMapping(value = {"/etapeJson/{id}"}, method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<EtapeJson> etapeJson(@PathVariable("id") Integer id) {
        Optional<Etape> etape = etapeRepository.findById(id);
        if (etape.isPresent())
            return ResponseEntity.ok(new EtapeJson(etape.get()));
        else
            return ResponseEntity.noContent().build();
    }

}
