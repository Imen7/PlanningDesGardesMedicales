package com.sifast.stage.model;

import java.util.HashMap;

public class Docteur {

	private String nom;
	private HashMap<String, PrefEnum> preference;
	
	//constructeur
	
	public Docteur() {
	}
	public Docteur(String nom) {
		this.nom = nom;
	}

	public Docteur( HashMap<String, PrefEnum> preference) {
		this.preference = preference;
	}
	
	// Nom set, get


	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public HashMap<String, PrefEnum> getPreference() {
		return preference;
	}

	public void setPreference(HashMap<String, PrefEnum> preference) {
		this.preference = preference;
	}


}