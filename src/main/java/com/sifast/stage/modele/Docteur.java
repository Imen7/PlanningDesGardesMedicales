package com.sifast.stage.modele;

import java.util.Date;
import java.util.HashMap;

public class Docteur {

	private String nom;
	private HashMap<String, PrefEnum> preference;
	
	//constructeur
	
	public Docteur( HashMap<String, PrefEnum> preference) {
		this.preference = preference;
	}
	
	// Nom set, get


	
	public Docteur() {
		// TODO Auto-generated constructor stub
	}

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