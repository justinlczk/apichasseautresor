package fr.cnam.usal3b.luczak.justin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.cnam.usal3b.luczak.justin.model.Brique;
import fr.cnam.usal3b.luczak.justin.model.BriqueTexte;
import fr.cnam.usal3b.luczak.justin.service.BriqueService;
import fr.cnam.usal3b.luczak.justin.service.CommonBriqueService;

@Service
public class CommonBriqueServiceImpl implements CommonBriqueService {

	@Autowired
	@Qualifier("briqueTexteServiceImpl")
	private BriqueService<BriqueTexte> briqueTexteService;

	@Override
	public List<? extends Brique> getAllBriques() {
		List<Brique> listeAllBriques = new ArrayList<>();
		for (BriqueTexte brique : briqueTexteService.getTout()) {
			listeAllBriques.add(brique);
		}
		return listeAllBriques;
	}

}
