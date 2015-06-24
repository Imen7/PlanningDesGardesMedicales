package com.sifast.stage.classe;

import com.toedter.calendar.JDateChooser;

public class PlanningGarde {
	String NomPlanning;
	JDateChooser DateDebut;
	JDateChooser DateFin;

	public PlanningGarde() {
		super();
	}

	public PlanningGarde(String NomPlanning, JDateChooser DateDebut,
			JDateChooser DateFin) {
		this.NomPlanning = NomPlanning;
		this.DateDebut = DateDebut;
		this.DateFin = DateFin;

	}

	public String getNomPlanning() {
		return NomPlanning;
	}

	public void setNomPlanning(String nomPlanning) {
		NomPlanning = nomPlanning;
	}

	public JDateChooser getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(JDateChooser dateDebut) {
		DateDebut = dateDebut;
	}

	public JDateChooser getDateFin() {
		return DateFin;
	}

	public void setDateFin(JDateChooser dateFin) {
		DateFin = dateFin;
	}

}
