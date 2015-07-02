package com.sifast.stage.modele;

import java.util.HashMap;

public class Docteur {

	String nom;
	private Preference preference = new Preference();
	public static HashMap<String, Preference> map = new HashMap<String,Preference>();

	// Nom set, get

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// preference set,get

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	public Preference getPreference() {
		return preference;
	}

	// static map ( nom, preference ) set,get
	
	public static HashMap<String, Preference> getMap() {
		return map;
	}

	public static void setMap(HashMap<String, Preference> map) {
		Docteur.map = map;
	}

	
}