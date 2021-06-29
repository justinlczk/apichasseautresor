package fr.cnam.usal3b.luczak.justin.service;

import java.util.List;

import fr.cnam.usal3b.luczak.justin.model.Brique;
import fr.cnam.usal3b.luczak.justin.model.Plot;

public interface BriqueService<T extends Brique> extends ChasseTresorService<T> {
	List<T> getBriquesPourPlot(Plot plot);
}
