package com.sifast.stage.modele;

import java.util.Date;
import java.util.HashMap;

public class Preference {

	private HashMap<Date, PrefEnum> mapPerference = new HashMap<Date, PrefEnum>();

    // constructeurs
	
	public Preference() {
		super();
	}

	public Preference(HashMap<Date, PrefEnum> mapPerference) {
		super();
		this.mapPerference = mapPerference;
	}
	
	// methodes set,get

	public HashMap<Date, PrefEnum> setPerference() {
		return mapPerference;
	}
	
	public HashMap<Date, PrefEnum> getPerference() {
		return mapPerference;
	}

	public String ToString(){
		return  mapPerference.toString();
	}
}
