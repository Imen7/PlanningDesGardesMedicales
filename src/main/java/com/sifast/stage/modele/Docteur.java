package com.sifast.stage.modele;

import java.util.ArrayList;

public class Docteur {

	private String nom;
	private ArrayList<Preference> preference=new ArrayList<Preference>();
	
	//constructeur
	
	public Docteur(String nom, ArrayList<Preference> preference) {
		super();
		this.nom = nom;
		this.preference = preference;
	}
	
	// Nom set, get


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	// preference set,get

	public ArrayList<Preference> getPreference() {
		return preference;
	}

	public void setPreference(ArrayList<Preference> preference) {
		this.preference = preference;
	}

	
	
}