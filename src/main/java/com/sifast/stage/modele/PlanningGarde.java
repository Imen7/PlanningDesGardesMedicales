package com.sifast.stage.modele;

import com.toedter.calendar.JDateChooser;

public class PlanningGarde {

	String NomPlanning;
	JDateChooser DateDebut;
	JDateChooser DateFin;

	// Constructeurs
	
	public PlanningGarde() {
	}

	public PlanningGarde(String NomPlanning, JDateChooser DateDebut, JDateChooser DateFin) {
		this.NomPlanning = NomPlanning;
		this.DateDebut = DateDebut;
		this.DateFin = DateFin;
	}

	// Methodes set,get
	
	public String getNomPlanning() {
		return NomPlanning;
	}

	public void setNomPlanning(String nomPlanning) {
		this.NomPlanning = nomPlanning;
	}

	public JDateChooser getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(JDateChooser dateDebut) {
		this.DateDebut = dateDebut;
	}

	public JDateChooser getDateFin() {
		return DateFin;
	}

	public void setDateFin(JDateChooser dateFin) {
		this.DateFin = dateFin;
	}

}
