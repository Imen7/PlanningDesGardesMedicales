package com.sifast.stage.classe;

import java.util.Date;
import java.util.HashMap;

public class Docteur {

	String nom;
	public static HashMap<String,  HashMap<Date, PrefEnum>> map=new HashMap<String,  HashMap<Date, PrefEnum>>();

	
	public HashMap<String,  HashMap<Date, PrefEnum>> getMap() {
		return map;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}